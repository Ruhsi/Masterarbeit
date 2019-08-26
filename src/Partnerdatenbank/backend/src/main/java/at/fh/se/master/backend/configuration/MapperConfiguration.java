package at.fh.se.master.backend.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public DozerBeanMapper createMapper(){
        return new DozerBeanMapper();
    }
}
