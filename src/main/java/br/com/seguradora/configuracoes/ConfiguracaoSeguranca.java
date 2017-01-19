package br.com.seguradora.configuracoes;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	//metodo de autenticacao, no caso em memoria
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 System.out.println("passei pelo metodo 1.1 cobfigure da classe Configuração Segurança");
		 auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		 System.out.println("passei pelo metodo 1.2 cobfigure da classe Configuração Segurança");
	}

	//parte de autorização.
	//1- http basic - simples - utilizado para webservice tambem.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println("passei pelo metodo 2.1 cobfigure da classe Configuração Segurança");
		http
			.authorizeRequests()
				.antMatchers("/app/carros/**", "/app/segurados/**").hasRole("ADMIN")
				.anyRequest().permitAll()
		.and().httpBasic();
		 System.out.println("passei pelo metodo 2.2 cobfigure da classe Configuração Segurança");
	}

}
