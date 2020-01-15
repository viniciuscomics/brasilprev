package br.com.app.brasilprev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@EnableSwagger2
@Configuration
public class SwaggerConfig {
 
	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.app.brasilprev.resource"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
	}
 
	private ApiInfoBuilder informacoesApi() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("pedidos-brasilprev");
		apiInfoBuilder.description("Api para realização de cadastro de produtos.");
		apiInfoBuilder.version("1.0");		
		apiInfoBuilder.licenseUrl("https://www1.brasilprev.com.br");
		apiInfoBuilder.contact(this.contato())
		.license("");
 
		return apiInfoBuilder;
 
	}
	private Contact contato() {
 
		return new Contact(
				"Vinicius Costa",
				"https://www1.brasilprev.com.br", 
				"vinicius_csa@yahoo.com.br");
	}
}
