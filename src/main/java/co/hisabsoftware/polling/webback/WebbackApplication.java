package co.hisabsoftware.polling.webback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class WebbackApplication {
@RequestMapping("/hello")

String hello(){
	return "hello spring";
}
	public static void main(String[] args) {
		SpringApplication.run(WebbackApplication.class, args);
	}
}
