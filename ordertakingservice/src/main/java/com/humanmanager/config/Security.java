package com.humanmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    SecurityFilterChain defaultSecurityChain(HttpSecurity security) throws Exception {
        security.csrf(csrfCustomizer -> csrfCustomizer.disable());
        security.sessionManagement(
                sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        security.authorizeHttpRequests(httpRequests -> httpRequests
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated());
        return security.build();
    }
}
