package com.darkfantasy.sercurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SECURITY CONFIG LOADED");
    // http
    // .authorizeHttpRequests(auth -> auth
    //     .requestMatchers(
    //         "/",
    //         "/login",
    //         "/css/**",
    //         "/js/**",
    //         "/img/**"
    //     ).permitAll()
    //     .anyRequest().authenticated()
    // )
    // .oauth2Login(oauth -> oauth
    //     .loginPage("/login")
    //     .defaultSuccessUrl("/", true)
    // );
    //     return http.build();
    

    
            http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login", "/story").permitAll()
            .anyRequest().authenticated()
        )
        .oauth2Login(oauth -> oauth
            .loginPage("/login")
        );
    return http.build();
    
    }
}
