package com.sebastiaofortes.security.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	
	// CONFIGURAÇÔES DE SEGURANÇA
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll() // endereço com acesso sem autenticação
		.antMatchers(HttpMethod.GET, "/sobre").permitAll() // endereço com acesso sem autenticação
		.antMatchers(HttpMethod.GET, "/cadastrarEvento").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/cadastrarEvento").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	

	
	

}
