package com.example.RestApiCRUD_operations_Ems.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
	
	@Bean
	InMemoryUserDetailsManager userDetailManager() {
		
		UserDetails Bunny=User.builder()
				.username("Bunny")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails kalu=User.builder()
				.username("kalu")
				.password("{noop}kalu123")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails shreyesh=User.builder()
				.username("shreyesh")
				.password("{noop}bunny123")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(Bunny,kalu,shreyesh);
		
	}
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->configurer
				.requestMatchers(HttpMethod.GET,"/list").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/showFormForAdd").hasRole("MANAGER")
				.requestMatchers(HttpMethod.GET,"/showFormForUpdate/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.GET,"/delete/**").hasRole("ADMIN")
				);
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(r->r.disable());
		return http.build();
		
	}

}
