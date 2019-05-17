package com.pack.hauphanvan.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pack.hauphanvan.domain.Customer;
import com.pack.hauphanvan.service.CustomerService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder manager) throws Exception {
		manager.inMemoryAuthentication().withUser("vanhau").password("vanhau").roles("USER", "ADMIN");
		manager.inMemoryAuthentication().withUser("john").password("john").roles("USER");
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/product/products").failureUrl("/login?errors");
		http.logout().logoutSuccessUrl("/login?logout");
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/**/add/").access("hasRole('ADMIN')").antMatchers("/**/about").access("hasRole('USER')");
		http.csrf().disable();
	}
}
