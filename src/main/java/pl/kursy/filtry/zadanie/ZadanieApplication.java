package pl.kursy.filtry.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import pl.kursy.filtry.zadanie.filter.UserFilter;

@SpringBootApplication
public class ZadanieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadanieApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean<UserFilter> loginFilter(){

		FilterRegistrationBean<UserFilter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new UserFilter());
		filter.addUrlPatterns("/login");
		filter.setOrder(1);

		return filter;

	}

}
