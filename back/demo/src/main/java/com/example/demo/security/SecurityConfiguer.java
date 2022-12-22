package com.example.demo.security;

import com.example.demo.service.MyUSerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfiguer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUSerDetailService myUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.csrf().disable().cors().configurationSource(corsConfigurationSource())
        .and()
        .authorizeRequests().antMatchers("/**/**").permitAll()
        ;
      httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    configuration.setAllowCredentials(true);
    //the below three lines will add the relevant CORS response headers
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
//    http.cors();
//  }

//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    final CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowedOrigins(ImmutableList.of("*"));
//    configuration.setAllowedMethods(ImmutableList.of("HEAD",
//      "GET", "POST", "PUT", "DELETE", "PATCH"));
//    // setAllowCredentials(true) is important, otherwise:
//    // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//    configuration.setAllowCredentials(true);
//    // setAllowedHeaders is important! Without it, OPTIONS preflight request
//    // will fail with 403 Invalid CORS request
//    configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
  }


