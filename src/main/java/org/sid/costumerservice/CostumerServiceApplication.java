package org.sid.costumerservice;

import org.sid.costumerservice.entities.costumer;
import org.sid.costumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CostumerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CostumerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository c, RepositoryRestConfiguration Rrc

							){
		Rrc.exposeIdsFor(costumer.class);
		return args ->{
			c.save(new costumer(null,"Mohamed","med@gmail.com"));
			c.save(new costumer(null,"Ikram","ikram@gmail.com"));
			c.save(new costumer(null,"Mourad","mourad@gmail.com"));
            c.findAll().forEach(a->{
				System.out.println(a.toString());
			});

		};

	}
}
