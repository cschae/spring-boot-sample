package abc.sample;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

	@RequestMapping("/**/*")
	public String test(HttpServletRequest req, @RequestBody(required = false) String body) {
		log.info("");
		String method = req.getMethod();
		String url = req.getRequestURI();
		log.info(method+" "+url);
		Enumeration<String> hnames = req.getHeaderNames();
		while(hnames.hasMoreElements()) {
			String name = hnames.nextElement();
			String value = req.getHeader(name);
			log.info(name+" : "+value);
			
		}
		log.info(body);
		return body;
	}
}
