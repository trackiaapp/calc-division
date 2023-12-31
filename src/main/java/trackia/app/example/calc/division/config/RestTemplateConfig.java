package trackia.app.example.calc.division.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import trackia.app.util.RestTemplateJournal;

@ComponentScan(basePackages = {"trackia.app"})
@Configuration
public class RestTemplateConfig {

    @Value("${server.connection-timeout:30000}") private String timeOut;

    @Bean
	public RestTemplateJournal restTemplate() {
		int timeout = Integer.parseInt(timeOut);
        
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setReadTimeout(timeout);
		RestTemplateJournal restTemplate = new RestTemplateJournal();
		restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
}
