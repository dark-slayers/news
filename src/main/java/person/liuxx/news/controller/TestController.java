package person.liuxx.news.controller;

import java.io.BufferedReader;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘湘湘
 * @since 2019年6月4日 上午9:43:36
 */
@RestController
public class TestController
{
    private Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello(ServletRequest request)
    {
        String ipAddress = request.getRemoteAddr();
        log.info("ip:{}", ipAddress);
        StringBuilder sb = new StringBuilder("");
        try (BufferedReader br = request.getReader();)
        {
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
        } catch (Exception e)
        {
            log.info("e:{}", e);
        }
        log.info("body:{}", sb);
        return "GET OK";
    }

    @PostMapping("/hello")
    public String postHello(ServletRequest request)
    {
        String ipAddress = request.getRemoteAddr();
        log.info("ip:{}", ipAddress);
        StringBuilder sb = new StringBuilder("");
        try (BufferedReader br = request.getReader();)
        {
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
        } catch (Exception e)
        {
            log.info("e:{}", e);
        }
        log.info("body:{}", sb);
        return "POST OK";
    }
}
