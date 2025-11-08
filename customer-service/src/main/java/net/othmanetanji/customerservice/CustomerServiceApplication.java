package net.othmanetanji.customerservice;

import net.othmanetanji.customerservice.entities.Customer;
import net.othmanetanji.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("othmane").email("othmanetanji@outlook.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("othaad").email("othaadtanji@outlook.com")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
            });
        };
    }

}
