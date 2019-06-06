package person.liuxx.news.service;

import java.util.Optional;

/**
 * @author 刘湘湘
 * @since 2019年5月22日 下午4:50:08
 */
public interface WebpageService
{
    Optional<String> getWebpageSource(String url);

    Optional<String> parseHtml(String html);
}
