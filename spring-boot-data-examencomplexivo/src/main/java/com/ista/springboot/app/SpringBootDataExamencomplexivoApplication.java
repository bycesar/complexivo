package com.ista.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ista.springboot.app.auth.JWTAuthorizationFilter;

@SpringBootApplication
public class SpringBootDataExamencomplexivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataExamencomplexivoApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class webSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/login").permitAll()
			.antMatchers(HttpMethod.GET,"/crearUsuario").permitAll()
			.antMatchers(HttpMethod.GET,"/login/{username}/{contrasena}").permitAll()
			.anyRequest().authenticated();
		}
	}
}
