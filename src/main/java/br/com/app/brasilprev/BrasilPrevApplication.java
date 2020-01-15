package br.com.app.brasilprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories
@EnableSwagger2
public class BrasilPrevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilPrevApplication.class, args);
	}

}
