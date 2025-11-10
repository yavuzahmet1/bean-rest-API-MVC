package org.learning.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "org.learning.entities")
@SpringBootApplication
public class JpaPostgreSqlLearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPostgreSqlLearningProjectApplication.class, args);
	}

}
