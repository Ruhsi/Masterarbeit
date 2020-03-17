package at.fh.se.master.partner.rest.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateProvider {
    @Bean
    RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}

