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
		 auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	//parte de autorização.
	//1- http basic - simples - utilizado para webservice tambem.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
			.authorizeRequests()
				.antMatchers("/app/carros/**", "/app/segurados/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			.and()
				.formLogin()
					.loginPage("/login.jsp")
					.loginProcessingUrl("/autenticar")
					.defaultSuccessUrl("/app/segurados")
					.failureUrl("/login.jsp?semacesso=true")
					.usernameParameter("usuario")
					.passwordParameter("senha")
				.and()
					.logout()
						.logoutUrl("/sair")
						.logoutSuccessUrl("/login.jsp?saiu=true");
	}

}
