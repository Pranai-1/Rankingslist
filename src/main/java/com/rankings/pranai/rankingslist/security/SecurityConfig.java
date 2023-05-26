package com.rankings.pranai.rankingslist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager manager() {
		UserDetails userdetails=User.builder()
		                       .passwordEncoder(input->encoder().encode(input))
		                       .username("pranai").password("reddy").roles("USER","ADMIN").build();
		UserDetails userdetails2=User.builder()
                .passwordEncoder(input->encoder().encode(input))
                .username("john").password("wick").roles("USER").build();
		return new InMemoryUserDetailsManager(userdetails,userdetails2);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filetr(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		
	}
}
