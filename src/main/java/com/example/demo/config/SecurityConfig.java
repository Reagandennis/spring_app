package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/auth/signup", "/auth/login", "/auth/recover").permitAll() // Permit these endpoints
                                .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.disable()) // Disable basic authentication
                .formLogin(login -> login.disable()) // Disable form login
                .sessionManagement(management -> management.disable()); // Disable session management

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
