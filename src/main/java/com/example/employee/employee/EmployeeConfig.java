package com.example.employee.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee one = new Employee(
                    "Nurbakhyt Madibekov",
                    "Software Engineer",
                    BigDecimal.valueOf(300000.50)
            );

            Employee two = new Employee(
                    "Dana Baymukanova",
                    "Project Manager",
                    BigDecimal.valueOf(500000.70)
            );

            Employee three = new Employee(
                    "Aisulu Kaidarova",
                    "Team Lead",
                    BigDecimal.valueOf(700000.80)
            );

            repository.saveAll(List.of(three, one, two));
        };
    }

}