package net.othmanetanji.inventoryservice;

import net.othmanetanji.inventoryservice.entities.Product;
import net.othmanetanji.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("OthmaneTanji PRODUCT 1")
                    .price(5000)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("OthmaneTanji PRODUCT 2")
                    .price(2500)
                    .quantity(5)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println("-------------------------------------");
                System.out.println(p.getQuantity());
                System.out.println(p.getPrice());
                System.out.println(p.getId());
                System.out.println(p.getName());
            });

        };

    }}
