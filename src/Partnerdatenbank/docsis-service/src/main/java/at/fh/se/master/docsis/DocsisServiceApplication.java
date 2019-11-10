package at.fh.se.master.docsis;

import at.fh.se.master.docsis.service.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DocsisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocsisServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LinkRepository linkRepository) {
        return args -> {

        };
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}
