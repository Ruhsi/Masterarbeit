package at.fh.se.master.backend;

import at.fh.se.master.backend.service.model.Address;
import at.fh.se.master.backend.service.model.MailAddress;
import at.fh.se.master.backend.service.model.Partner;
import at.fh.se.master.backend.service.model.PhoneNumber;
import at.fh.se.master.backend.service.repository.PartnerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PartnerRepository partnerRepository) {
        return args -> {
            partnerRepository.deleteAll();

            Partner p = new Partner();
            p.setFirstname("Christoph");
            p.setLastname("Ruhsam");
            p.setTitle("BSc");
            p.setAddress(
                    new Address() {{
                        setCity("Schenkenfelden");
                        setCountry("Austria");
                        setPostalCode("4192");
                        setStreet("Hinterkönigschlag");
                        setStreetNumber(14);
                    }}
            );

            Set<MailAddress> mails = new HashSet<>();
            mails.add(
                    new MailAddress() {{
                        setMailAddress("ruhsamchristoph@gmail.com");
                        setPrivate(true);
                    }}
            );
            mails.add(
                    new MailAddress() {{
                        setMailAddress("christoph.ruhsam@gepardec.com");
                        setPrivate(false);
                    }}
            );
            p.setMailadresses(mails);

            Set<PhoneNumber> phoneNumbers = new HashSet<>();
            phoneNumbers.add(
                    new PhoneNumber() {{
                        setPhoneNumber("067761278905");
                        setPrivate(true);
                    }}
            );
            phoneNumbers.add(
                    new PhoneNumber() {{
                        setPhoneNumber("01234567989");
                        setPrivate(false);
                    }}
            );
            p.setPhoneNumbers(phoneNumbers);

            partnerRepository.save(p);

            ObjectMapper mapper = new ObjectMapper();

            partnerRepository.findAll().forEach(o -> {
                try {
                    System.out.println(mapper.writeValueAsString(o));
                }
                catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
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
