//package com.voyageVault.SecurityYatra.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
//import org.springframework.security.oauth2.core.OAuth2Error;
//import org.springframework.security.oauth2.core.OAuth2TokenValidator;
//import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
//import org.springframework.security.oauth2.jwt.*;
//
//@Configuration
//public class JwtConfig {
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        // Returns a NimbusJwtDecoder under the hood
//        NimbusJwtDecoder decoder = (NimbusJwtDecoder)
//                JwtDecoders.fromIssuerLocation("https://accounts.google.com");
//
//        String expectedAud = "YOUR_GOOGLE_CLIENT_ID";
//
//        // Validates iss, exp, nbf, etc.
//        OAuth2TokenValidator<Jwt> withIssuer =
//                JwtValidators.createDefaultWithIssuer("https://accounts.google.com");
//
//        // Validate audience claim
//        OAuth2TokenValidator<Jwt> withAudience = token -> {
//            if (token.getAudience() != null && token.getAudience().contains(expectedAud)) {
//                return OAuth2TokenValidatorResult.success();
//            }
//            return OAuth2TokenValidatorResult.failure(
//                    new OAuth2Error("invalid_token", "Invalid audience", null)
//            );
//        };
//
//        // Combine validators
//        decoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(withIssuer, withAudience));
//        return decoder;
//    }
//}
