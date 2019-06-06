package person.liuxx.news.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import person.liuxx.news.service.WebpageService;
import person.liuxx.util.net.HttpUtil;

/**
 * @author 刘湘湘
 * @since 2019年5月22日 下午5:37:33
 */
@Service
public class WebpageServiceImpl implements WebpageService
{
    private Logger log = LoggerFactory.getLogger(WebpageServiceImpl.class);

    @Override
    public Optional<String> getWebpageSource(String url)
    {
        return HttpUtil.simpleGet(url);
    }

    private Optional<String> getMostTagClassName(String htmlString)
    {
        Pattern p = Pattern.compile("class=\".*?\"");
        Matcher m = p.matcher(htmlString.toLowerCase());
        Map<String, Integer> map = new HashMap<>();
        while (m.find())
        {
            String findString = m.group();
            String classArrayString = findString.substring(7, findString.length() - 1);
            log.debug("classArrayString:{}", classArrayString);
            Arrays.stream(classArrayString.split(" ")).forEach(n -> addClassNameToMap(n, map));
        }
        log.debug("map:{}", map);
        Stream<Entry<String, Integer>> entryStream = map.entrySet().stream();
        Optional<String> result = entryStream.max(Map.Entry.comparingByValue()).map(en -> en
                .getKey());
        return result;
    }

    private void addClassNameToMap(String name, Map<String, Integer> map)
    {
        int oldValue = map.getOrDefault(name, 0);
        map.put(name, oldValue + 1);
    }

    @Override
    public Optional<String> parseHtml(String html)
    {
        String mostClassName = getMostTagClassName(html).orElse("");
        log.info("mostClassName:{}", mostClassName);
        return Optional.of("over");
    }
}
