package br.com.app.brasilprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.app.brasilprev.properties.ApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties.class)
public class BrasilPrevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilPrevApplication.class, args);
	}

}
