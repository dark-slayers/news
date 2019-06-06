package person.liuxx.news.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import person.liuxx.news.NewsApplication;
import person.liuxx.news.service.WebpageService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsApplication.class)
@WebAppConfiguration
public class WebpageServiceImplTest
{
    private Logger log = LoggerFactory.getLogger(WebpageServiceImplTest.class);
    @Autowired
    private WebpageService service;

    /**
     * @author 刘湘湘
     * @since 2019年5月22日 下午5:49:05
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @author 刘湘湘
     * @since 2019年5月22日 下午5:49:05
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void test()
    {
        String url="https://www.taptap.com/top/download";
        String source = service.getWebpageSource(url).get();
        String p=service.parseHtml(source).orElse("error!");
        log.info("get url:{},parse result：{}",url,p);
    }
}
