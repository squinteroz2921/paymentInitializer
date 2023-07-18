package com.co.bancolombia.paymentInitializer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Value;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Value("${spring.security.oauth2.resource-server.jwt.jwk-set-uri}")
    String jwksSetUri;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests((auth) -> auth
                        .anyRequest().authenticated())
                .oauth2ResourceServer((oAuth2Resoucer)-> oAuth2Resoucer.jwt(Customizer.withDefaults()));
        return httpSecurity.build();
    }

    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withJwkSetUri(jwksSetUri).build();
    }
}
