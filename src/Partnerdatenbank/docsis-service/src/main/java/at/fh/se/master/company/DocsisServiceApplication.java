package at.fh.se.master.company;

import at.fh.se.master.company.service.model.Link;
import at.fh.se.master.company.rest.controller.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DocsisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocsisServiceApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner commandLineRunner(LinkRepository linkRepository) {
        return args -> {
            linkRepository.deleteAll();

            Link link = new Link();
            link.setLink("www.orf.at");
            link.setLinkDescription("This is the link to Orf.");
            link.setPartnerId(1);
            linkRepository.save(link);

            Link link1 = new Link();
            link1.setLink("www.fh-hagenberg.at");
            link1.setLinkDescription("This is the link to Hagenbergs Website.");
            link1.setPartnerId(1);
            linkRepository.save(link1);

            Link link2 = new Link();
            link2.setLink("www.fh-ooe.at");
            link2.setLinkDescription("This is the link to FH OOE Website.");
            link2.setPartnerId(1);
            linkRepository.save(link2);

            Link link3 = new Link();
            link3.setLink("www.sport.orf.at");
            link3.setLinkDescription("This is the link to Sport ORF.");
            link3.setPartnerId(2);
            linkRepository.save(link3);

            Link link4 = new Link();
            link4.setLink("www.test.at");
            link4.setLinkDescription("This is a test link.");
            link4.setPartnerId(2);
            linkRepository.save(link4);
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

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("at.fh.se.master.docsis")).build();
    }
}
