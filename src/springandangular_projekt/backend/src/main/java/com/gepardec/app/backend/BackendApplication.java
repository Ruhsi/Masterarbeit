package com.gepardec.app.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gepardec.app.backend.article.Article;
import com.gepardec.app.backend.common.Discount;
import com.gepardec.app.backend.common.StatusItem;
import com.gepardec.app.backend.customer.Customer;
import com.gepardec.app.backend.offer.Offer;
import com.gepardec.app.backend.offer.OfferItem;
import com.gepardec.app.backend.repository.ArticleRepository;
import com.gepardec.app.backend.repository.CustomerRepository;
import com.gepardec.app.backend.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {
    public static void main (String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (OfferRepository offerRepository, ArticleRepository articleRepository, CustomerRepository customerRepository) {
        return args -> {
            customerRepository.deleteAll();
            articleRepository.deleteAll();
            offerRepository.deleteAll();

            final List<Article> articleList = new LinkedList<>();
            articleList.add(new Article("Article1", 124.87));
            articleList.add(new Article("Article2", 178.10));
            articleList.add(new Article("Article3", 100.00));
            articleList.add(new Article("Article4", 133.7));
            articleList.add(new Article("Article5", 89.81));

            articleRepository.saveAll(articleList);

            final List<Customer> customerList = new LinkedList<>();
            customerList.add(new Customer("Felix", "Zimmerman"));
            customerList.add(new Customer("Nadine", "Abend"));
            customerList.add(new Customer("Robert", "Förster"));
            customerList.add(new Customer("Florian", "Ackermann"));
            customerList.add(new Customer("Ursula", "Hoffmann"));

            customerRepository.saveAll(customerList);

            final Customer customer = customerRepository.findById((long) 2).orElse(null);
            final Article article1 = articleRepository.findById((long) 3).orElse(null);
            final Article article2 = articleRepository.findById((long) 1).orElse(null);
            final Article article3 = articleRepository.findById((long) 2).orElse(null);

            final Offer offer = new Offer();
            offer.setCustomer(customer);
            offer.setOfferDate(Instant.now());

            final StatusItem statusItem = new StatusItem();
            statusItem.setCanceled(false);
            statusItem.setCancelTime(null);

            offer.setStatus(statusItem);

            final OfferItem offerItem1 = new OfferItem();
            offerItem1.setArticle(article1);
            offerItem1.addDiscount(new Discount("Mengenrabatt"));
            offerItem1.addDiscount(new Discount("Neukundenrabatt"));

            offer.addOfferPosition(offerItem1);

            final OfferItem offerItem2 = new OfferItem();
            offerItem2.setArticle(article2);
            offerItem2.addDiscount(new Discount("Sommerrabatt"));

            offer.addOfferPosition(offerItem2);

            final OfferItem offerItem3 = new OfferItem();
            offerItem3.setArticle(article3);

            offer.addOfferPosition(offerItem3);

            offerRepository.save(offer);

            ObjectMapper mapper = new ObjectMapper();

            offerRepository.findAll().forEach(o -> {
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
    public WebMvcConfigurer corsConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings (CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
