//package com.voyageVault.SecurityYatra.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtValidators;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.core.OAuth2Error;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    // ===== API chain (Android) — stateless, JWT, no sessions =====
//    @Bean
//    @Order(1)
//    SecurityFilterChain apiChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/api/**")
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/public/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()))
//                .csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//
//    // ===== Web chain (Browser) — Google OAuth2 login + server sessions =====
//    @Bean
//    @Order(2)
//    SecurityFilterChain webChain(HttpSecurity http) throws Exception {
//        http
//                // Allow static assets and login
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/login", "/css/**", "/js/**", "/images/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//
//                // Google OAuth2 login (from application.yml client config)
//                .oauth2Login(Customizer.withDefaults())
//
//                // Logout clears session + cookie
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                )
//
//                // Web sessions are server-managed (with 30m idle timeout from application.yml)
//                .sessionManagement(sm ->
//                        sm.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                );
//
//        return http.build();
//    }
//}
//
//
//
