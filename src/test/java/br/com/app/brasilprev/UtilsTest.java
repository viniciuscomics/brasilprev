package br.com.app.brasilprev;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class UtilsTest {
	
	public static HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory()
    {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
         
        clientHttpRequestFactory.setHttpClient(httpClient());
              
        return clientHttpRequestFactory;
    }
     
    public static HttpClient httpClient()
    {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
 
        credentialsProvider.setCredentials(AuthScope.ANY,
                        new UsernamePasswordCredentials("admin@adm.com", "admin"));
 
        HttpClient client = HttpClientBuilder
                                .create()
                                .setDefaultCredentialsProvider(credentialsProvider)
                                .build();
        return client;
    }

}
