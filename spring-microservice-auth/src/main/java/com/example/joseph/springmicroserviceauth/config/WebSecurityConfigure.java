package com.example.joseph.springmicroserviceauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Spring Security - We override methods so that the OAuth2 configuration class can override and see
@Configuration
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    return super.userDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .passwordEncoder(passwordEncoder())
            .withUser("joseph")
            .password(passwordEncoder().encode("joseph12345"))
            .roles("USER", "TEST");
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(HttpMethod.GET, "/actuator/**");
  }

}
