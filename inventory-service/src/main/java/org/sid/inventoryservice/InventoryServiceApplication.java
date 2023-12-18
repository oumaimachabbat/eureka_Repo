package org.sid.inventoryservice;

import org.sid.inventoryservice.repository.ProductRepository;
import org.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"Ordinateur",5000,12));
			productRepository.save(new Product(null,"Imprimante",1000,39));
			productRepository.save(new Product(null,"Smartphone",1500,46));
			productRepository.findAll().forEach(p->{
				System.out.println(p.getName());
			});
		};
	}

}
