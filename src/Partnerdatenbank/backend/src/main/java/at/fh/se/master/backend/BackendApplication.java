package at.fh.se.master.backend;

import at.fh.se.master.backend.security.model.Role;
import at.fh.se.master.backend.security.model.Users;
import at.fh.se.master.backend.service.model.*;
import at.fh.se.master.backend.service.repository.PartnerRepository;
import at.fh.se.master.backend.service.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PartnerRepository partnerRepository, UsersRepository userRepository) {
        return args -> {

            userRepository.deleteAll();
            Role adminRole = new Role();
            adminRole.setRole("ADMIN");

            Role userRole = new Role();
            userRole.setRole("USER");

            Users user1 = new Users();
            user1.setActive(1);
            user1.setEmail("ruhsamchristoph@gmail.com");
            user1.setName("Ruhsi");
            user1.setLastName("Ruhsam");
            user1.setPassword("chrisi");
            user1.setRoles(new HashSet<Role>(){{add(adminRole);}});
            userRepository.save(user1);

            Users user2 = new Users();
            user2.setActive(1);
            user2.setEmail("christoph.ruhsam@gepardec.com");
            user2.setName("Gepard");
            user2.setLastName("Ruhsam");
            user2.setPassword("gepard");
            user2.setRoles(new HashSet<Role>(){{add(userRole);}});
            userRepository.save(user2);


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
