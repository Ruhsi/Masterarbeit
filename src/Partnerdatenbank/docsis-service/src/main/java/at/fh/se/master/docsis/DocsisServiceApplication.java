package at.fh.se.master.docsis;

import at.fh.se.master.docsis.service.model.Link;
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

}
