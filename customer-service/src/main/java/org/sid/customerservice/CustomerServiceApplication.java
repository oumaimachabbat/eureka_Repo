package org.sid.customerservice;

import org.sid.customerservice.entities.customer;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					customer.builder().nom("oumaima").email("oumaima@gmail.com").build(),
					customer.builder().nom("ouma").email("ouma@gmail.com").build(),
					customer.builder().nom("oum").email("oum@gmail.com").build()

			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
