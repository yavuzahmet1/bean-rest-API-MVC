package org.learn.jpapostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"org.learn.entities"})
@ComponentScan(basePackages = {"org.learn.controller", "org.learn.services", "org.learn.repository"})
@EnableJpaRepositories(basePackages = {"org.learn.repository"})
public class JpaPostgreSqlLearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPostgreSqlLearningProjectApplication.class, args);
	}

}
