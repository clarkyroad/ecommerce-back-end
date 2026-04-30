package com.devcenterhouse.ecommerce;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.devcenterhouse.ecommerce.serviceoffer.ServiceOffer;
import com.devcenterhouse.ecommerce.serviceoffer.ServiceOfferRepository;
import com.devcenterhouse.ecommerce.technologystack.TechnologyStack;
import com.devcenterhouse.ecommerce.technologystack.TechnologyStackRepository;

import java.util.List;

import org.slf4j.Logger;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public CommandLineRunner initializeServiceOffers(ServiceOfferRepository serviceOfferRepository) {
        return args -> {
            if(serviceOfferRepository.count() == 0) {
                logger.info("Initializing service offers...");
            
                ServiceOffer offer1 = new ServiceOffer();
                offer1.setTitle("E-Commerce Development");
                offer1.setDescription("Build scalable and secure online storefronts with modern technologies");
                offer1.setIcon("🛒");
                serviceOfferRepository.save(offer1);

                ServiceOffer offer2 = new ServiceOffer();
                offer2.setTitle("Payment Integration");
                offer2.setDescription("Seamless integration with multiple payment gateways and processors");
                offer2.setIcon("💳");
                serviceOfferRepository.save(offer2);

                ServiceOffer offer3 = new ServiceOffer();
                offer3.setTitle("Inventory Management");
                offer3.setDescription("Real-time inventory tracking and stock management solutions");
                offer3.setIcon("📦");
                serviceOfferRepository.save(offer3);

                ServiceOffer offer4 = new ServiceOffer();
                offer4.setTitle("Customer Analytics");
                offer4.setDescription("Comprehensive analytics and customer behavior insights.");
                offer4.setIcon("📊");
                serviceOfferRepository.save(offer4);

                ServiceOffer offer5 = new ServiceOffer();
                offer5.setTitle("Mobile Commerce");
                offer5.setDescription("Responsive and optimized mobile shopping experiences");
                offer5.setIcon("📱");
                serviceOfferRepository.save(offer5);

                ServiceOffer offer6 = new ServiceOffer();
                offer6.setTitle("Customer Support");
                offer6.setDescription("24/7 customer support for resolving issues and providing assistance");
                offer6.setIcon("💬");
                serviceOfferRepository.save(offer6);

                logger.info("Sample service offers created successfully!");
            }
        };
    }

    @Bean
    public CommandLineRunner initializeTechnologyStacks(TechnologyStackRepository technologyStackRepository) {
        return args -> {
            if(technologyStackRepository.count() == 0) {
                logger.info("Initializing technology stacks...");

                List<String> frontendTech = List.of("React", "Angular", "Vue.js", "TypeScript", "Tailwind CSS");
                TechnologyStack stack1 = new TechnologyStack();
                stack1.setCategory("Frontend");
                stack1.setTechnologies(frontendTech);
                technologyStackRepository.save(stack1); 

                List<String> backendTech = List.of("Java", "Spring Boot", "Node.js", "Python");
                TechnologyStack stack2 = new TechnologyStack();
                stack2.setCategory("Backend");
                stack2.setTechnologies(backendTech);
                technologyStackRepository.save(stack2);

                List<String> databaseTech = List.of("MySQL", "PostgreSQL", "MongoDB", "Redis");
                TechnologyStack stack3 = new TechnologyStack();
                stack3.setCategory("Database");
                stack3.setTechnologies(databaseTech);
                technologyStackRepository.save(stack3);

                List<String> cloudDevOpsTech = List.of("AWS", "Azure", "Docker", "Kubernetes");
                TechnologyStack stack4 = new TechnologyStack();
                stack4.setCategory("Cloud and DevOps");
                stack4.setTechnologies(cloudDevOpsTech);
                technologyStackRepository.save(stack4);

                logger.info("Sample technology stacks created successfully!");
            }
        };
    }

    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
