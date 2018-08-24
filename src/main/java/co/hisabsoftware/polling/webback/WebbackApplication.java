package co.hisabsoftware.polling.webback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
public class WebbackApplication
    extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws  Exception {
        http.antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

	public static void main(String[] args) {
		SpringApplication.run(WebbackApplication.class, args);
	}
}
