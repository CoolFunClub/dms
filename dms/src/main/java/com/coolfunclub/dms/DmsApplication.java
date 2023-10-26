package com.coolfunclub.dms;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class DmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsApplication.class, args);
	}


    	@Bean
    	public CorsFilter corsFilter() {
        	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        	CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);

		config.addAllowedOrigin("*");
        	config.addAllowedMethod("*");
        	config.addAllowedHeader("*");
        	source.registerCorsConfiguration("/**", config);
        	return new CorsFilter(source);
    	}
}