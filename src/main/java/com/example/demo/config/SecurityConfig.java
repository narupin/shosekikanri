package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
					.requestMatchers("/h2-console/**").permitAll()	// H2DBデバッグ用
					.requestMatchers("/error").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/login").permitAll()
			)
			.logout((logout) -> logout.permitAll()
			);
		
		http.csrf().disable();	// H2DBデバッグ用
		http.headers().frameOptions().disable(); // H2DBデバッグ用
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
				User.withUsername("test")
					.password(passwordEncoder().encode("pass"))
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}	
}
