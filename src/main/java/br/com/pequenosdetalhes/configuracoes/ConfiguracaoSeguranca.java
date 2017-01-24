package br.com.pequenosdetalhes.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.pequenosdetalhes.modelo.servicos.ServicoAutenticacao;
 
@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired private ServicoAutenticacao servicoAutenticacao;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//metodo de autenticacao, no caso em memoria
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		
		auth
			.userDetailsService(servicoAutenticacao)
			.passwordEncoder(encoder()); //para NAO salvar senha em texto limpo e SIM encriptada
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	//parte de autorização.
	//1- http basic - simples - utilizado para webservice tambem.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http.authorizeRequests()
		 .antMatchers("/").permitAll()
		 //.antMatchers("/home").permitAll()
		 .antMatchers("/app/segurados**").access("hasRole('ROLE_ADMIN')")
		 .and().httpBasic();*/
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/festasTemas**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/artefatos/**").access("hasRole('ROLE_ADMIN')")
				
			.and()
				.formLogin()
					.loginPage("/login.jsp")
					.loginProcessingUrl("/autenticar")
					.defaultSuccessUrl("/artefatos")
					.failureUrl("/login.jsp?semacesso=true")
					.usernameParameter("usuario")
					.passwordParameter("senha")
				.and()
					.logout()
						.logoutUrl("/sair")
						.logoutSuccessUrl("/login.jsp?saiu=true");
			//.and()
			//	.csrf().disable();
			// se estivesse usando rest, talvez seja interessante desabilitar
			
	}
	
	public static void main (String[] args){
		
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		String pe = p.encode("admin");
		System.out.println(">>>>>> " +  pe);
		
	}

}
