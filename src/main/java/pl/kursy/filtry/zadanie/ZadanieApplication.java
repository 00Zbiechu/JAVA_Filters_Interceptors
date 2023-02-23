package pl.kursy.filtry.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import pl.kursy.filtry.zadanie.filter.RequestAuthorizationHeaderFilter;

@SpringBootApplication
public class ZadanieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadanieApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean<RequestAuthorizationHeaderFilter> loginFilter(){

		FilterRegistrationBean<RequestAuthorizationHeaderFilter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new RequestAuthorizationHeaderFilter());
		filter.addUrlPatterns("/login/*");
		filter.setOrder(1);

		return filter;

	}

}
