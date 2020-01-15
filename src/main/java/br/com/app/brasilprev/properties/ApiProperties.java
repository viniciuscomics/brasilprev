package br.com.app.brasilprev.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("appapi")
@Getter
@Setter
public class ApiProperties {

	private String originPermitida;

}
