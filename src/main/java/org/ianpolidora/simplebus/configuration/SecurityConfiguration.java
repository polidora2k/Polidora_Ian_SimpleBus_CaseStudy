package org.ianpolidora.simplebus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration { 
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
	    	.authorizeRequests()
	    		.antMatchers("/", "/user/**", "/images/**", "/fonts/**", "/scripts/**", "/styles/**").permitAll()
	    		.anyRequest().authenticated()
	    		.and()
	    	.formLogin()
	    		.loginPage("/user/login")
	    		.loginProcessingUrl("/login/submit")
	    		.defaultSuccessUrl("/parent")
	    		.and()
    		.logout()
	            .invalidateHttpSession(true)
	            .logoutUrl("/user/logout")
	            .logoutSuccessUrl("/index");

        return http.build();
    }
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
