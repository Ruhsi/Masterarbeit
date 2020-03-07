package at.fh.se.master.partner;

import at.fh.se.master.partner.security.model.Role;
import at.fh.se.master.partner.security.model.Users;
import at.fh.se.master.partner.service.model.*;
import at.fh.se.master.partner.rest.repository.CompanyRepository;
import at.fh.se.master.partner.rest.repository.PartnerRepository;
import at.fh.se.master.partner.rest.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner commandLineRunner(PartnerRepository partnerRepository,
                                               UsersRepository userRepository,
                                               CompanyRepository companyRepository) {
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
            user1.setRoles(new HashSet<Role>() {{
                add(adminRole);
            }});
            userRepository.save(user1);

            Users user2 = new Users();
            user2.setActive(1);
            user2.setEmail("christoph.ruhsam@gepardec.com");
            user2.setName("Gepard");
            user2.setLastName("Ruhsam");
            user2.setPassword("gepard");
            user2.setRoles(new HashSet<Role>() {{
                add(userRole);
            }});
            userRepository.save(user2);


            companyRepository.deleteAll();
            partnerRepository.deleteAll();

            // HAGENBERG
            Company hagenberg = new Company();
            hagenberg.setCreditorNumber("C0000");
            hagenberg.setCreditorName("FH Oberösterreich Campus Hagenberg");
            hagenberg.setCreditorStatus('J');
            hagenberg.setShortName("JKU");
            hagenberg.setAendCounter(1);
            hagenberg.setMandant("JKU");
            hagenberg.setKontoNrSAPOld("AT 1000 2000 3000 4000 5000");

            Address hagenbergAddress = new Address();
            hagenbergAddress.setStreet("Softwarepark");
            hagenbergAddress.setStreetNumber(11);
            hagenbergAddress.setPostalCode("4232");
            hagenbergAddress.setCity("Hagenberg im Mühlkreis");
            hagenbergAddress.setCountry("Österreich");
            hagenberg.setAddress(hagenbergAddress);

            addPartnersHagenberg(hagenberg, partnerRepository);

            // JKU
            Company jku = new Company();
            jku.setCreditorNumber("C1000");
            jku.setCreditorName("Johannes Kepler Universität Linz - JKU");
            jku.setCreditorStatus('J');
            jku.setShortName("JKU");
            jku.setAendCounter(1);
            jku.setMandant("JKU");
            jku.setKontoNrSAPOld("AT 1000 2000 3000 4000 5000");

            Address jkuAddress = new Address();
            jkuAddress.setStreet("Altenbergerstraße");
            jkuAddress.setStreetNumber(69);
            jkuAddress.setPostalCode("4040");
            jkuAddress.setCity("Linz");
            jkuAddress.setCountry("Österreich");
            jku.setAddress(jkuAddress);

            addPartnersJKU(jku, partnerRepository);

            companyRepository.save(hagenberg);
            companyRepository.save(jku);

            ObjectMapper mapper = new ObjectMapper();

            partnerRepository.findAll().forEach(o -> {
                try {
                    System.out.println(mapper.writeValueAsString(o));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        };
    }

    private void addPartnersHagenberg(Company hagenerg, PartnerRepository partnerRepository) {
        Partner affenzeller = new Partner();
        affenzeller.setFirstname("Michael");
        affenzeller.setLastname("Affenzeller");
        affenzeller.setTitleBefore("FH-Prof. PD DI Dr.");
        affenzeller.setAddress(null);

        Set<MailAddress> mails = new HashSet<>();
        mails.add(
                new MailAddress() {{
                    setMailAddress("michael.affenzeller@fh-hagenberg.at");
                    setPrivate(false);
                }}
        );
        affenzeller.setMailadresses(mails);

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(
                new PhoneNumber() {{
                    setPhoneNumber("+43 5 0804 22031");
                    setPrivate(false);
                }}
        );
        affenzeller.setPhoneNumbers(phoneNumbers);
        affenzeller.setTopic("Professor of Heuristic Optimisation/Machine Learning");

        hagenerg.setPartners(new ArrayList<>() {{
            add(affenzeller);
        }});
    }

    private void addPartnersJKU(Company jku, PartnerRepository partnerRepository) {
        Partner altrichter = new Partner();
        altrichter.setFirstname("Herbert");
        altrichter.setLastname("Altrichter");
        altrichter.setTitleBefore("o. Univ.-Prof. Dr.");
        altrichter.setAddress(new Address() {{
            setStreet("Keplergebäude");
            setStreetNumber(1);
            setPostalCode("4192");
            setCity("Linz");
            setCountry("Österreich");
        }});

        Set<MailAddress> mails = new HashSet<>();
        mails.add(
                new MailAddress() {{
                    setMailAddress("herbert.altrichter@jku.at");
                    setPrivate(false);
                }}
        );
        altrichter.setMailadresses(mails);

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(
                new PhoneNumber() {{
                    setPhoneNumber("+43 732 2468 7241");
                    setPrivate(false);
                }}
        );
        altrichter.setPhoneNumbers(phoneNumbers);
        altrichter.setTopic("Schulentwicklung und Governance des Bildungswesens");


        Partner dastel = new Partner();
        dastel.setFirstname("Bettina");
        dastel.setLastname("Dastel");
        altrichter.setAddress(new Address() {{
            setStreet("Keplergebäude");
            setStreetNumber(1);
            setPostalCode("4192");
            setCity("Linz");
            setCountry("Österreich");
        }});

        mails = new HashSet<>();
        mails.add(
                new MailAddress() {{
                    setMailAddress("bettina.dastel@jku.at");
                    setPrivate(false);
                }}
        );
        dastel.setMailadresses(mails);

        phoneNumbers = new HashSet<>();
        phoneNumbers.add(
                new PhoneNumber() {{
                    setPhoneNumber("+43 732 2468 7240");
                    setPrivate(false);
                }}
        );
        dastel.setTopic("Professor of User Experience and Interaction Design");
        dastel.setPhoneNumbers(phoneNumbers);


        jku.setPartners(new ArrayList<>() {{
            add(altrichter);
            add(dastel);
        }});
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
                .apis(RequestHandlerSelectors.basePackage("at.fh.se.master.company")).build();
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }
}
