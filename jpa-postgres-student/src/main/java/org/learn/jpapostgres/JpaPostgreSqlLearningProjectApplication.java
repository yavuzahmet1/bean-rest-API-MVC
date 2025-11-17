package org.learn.jpapostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"org.learn.entities"})
@SpringBootApplication
public class JpaPostgreSqlLearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPostgreSqlLearningProjectApplication.class, args);
	}

}
