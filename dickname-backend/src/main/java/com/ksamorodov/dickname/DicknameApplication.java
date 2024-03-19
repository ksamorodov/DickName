package com.ksamorodov.dickname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = {"com.*"})
@EntityScan("com.*")
public class DicknameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicknameApplication.class, args);
	}

}
