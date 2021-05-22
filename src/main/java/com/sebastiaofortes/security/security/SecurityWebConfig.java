package com.sebastiaofortes.security.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()        // endereço com acesso permitido a todos
		.antMatchers(HttpMethod.GET, "/sobre").permitAll()		// endereço cm acesso permitido a todos
		.anyRequest().authenticated()
		.and().formLogin().permitAll()    
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); // url para cancelar a sessão
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication() 							// método que permite a criação de usuários para autenticação em memória
		.withUser("michelli").password("{noop}123").roles("ADMIN");
		
		//O formato de armazenamento de senhas do Spring security 5 ou posterior é {encrypt}password. Adicione {noop}, antes da senha. 
		//{noop} informa que a senha é um texto simples, nenhuma criptografia é usada.
		
	}

	@Override
	public void configure(WebSecurity web) throws java.lang.Exception{
		web.ignoring().antMatchers("/materialize/**", "/style/**"); // método para o spring security não bloquear as pastas estáticas definidas
	}
	
	

	
	

}
