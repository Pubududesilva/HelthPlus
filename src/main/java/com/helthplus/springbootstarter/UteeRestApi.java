package com.helthplus.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.CodecConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.helthplus.springbootstarter.filters.AuthFilter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UteeRestApi extends SpringBootServletInitializer{


	public static void main(String[] args)  {
		SpringApplication.run(UteeRestApi.class, args);

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UteeRestApi.class);
	}
	
	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistationBean(){
		FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		filterRegistrationBean.setFilter(authFilter);
		filterRegistrationBean.addUrlPatterns("/api/categories/*");
		filterRegistrationBean.addUrlPatterns("/api/profile/*");
//		filterRegistrationBean.addUrlPatterns("/api/doctor/*");
		return filterRegistrationBean;
		
	}
	
//	@Bean
//	public WebMvcConfigurer CorsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
//				.allowCredentials(true);
//			}
//		};

//	}

}




