package com.Restaurants.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Restaurants.ServiceImpl.AuthUserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguretion {

	@Autowired
	private AuthUserServiceImpl userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint authorizedHandler;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
//				.authorizeHttpRequests(
//						auth -> auth.requestMatchers(
//								"/generate-token",
//								"/user/users/register",
//								"/rest/get/**",
//								"/rest/getAll",
//								"/get/food/**"
//								).permitAll().anyRequest().authenticated())
//				.exceptionHandling(exception -> exception.authenticationEntryPoint(authorizedHandler))
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//		return httpSecurity.build();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity
	        .csrf(csrf -> csrf.disable())
	        .cors(cors -> cors.disable())
	        .authorizeHttpRequests(authorize ->
	            authorize
	                .requestMatchers(
	                    "/generate-token",
	                    "/user/users/register",
	                    "/rest/get/**",
	                    "/rest/getAll",
	                    "/get/food/**"
	                ).permitAll()
	                .requestMatchers("/emp/**").hasRole("restaurant")
	                .requestMatchers("/register").hasRole("admin")
	                .anyRequest().authenticated()
	        )
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(authorizedHandler))
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	    httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	    return httpSecurity.build();
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public CorsFilter corsFilter() {
		return new CorsFilter();
	}
}
