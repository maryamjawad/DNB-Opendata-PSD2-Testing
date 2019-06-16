package no.maryam.dnb.opendata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DnbOpendataPsd2TestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DnbOpendataPsd2TestingApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
