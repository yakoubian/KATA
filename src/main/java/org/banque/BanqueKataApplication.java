package org.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"org.banque.entities"})  // scan JPA entities
@ImportResource("spring-config.xml")
public class BanqueKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueKataApplication.class, args);
	}
}
