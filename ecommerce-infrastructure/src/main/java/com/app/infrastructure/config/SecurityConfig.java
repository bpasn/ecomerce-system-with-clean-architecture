package com.app.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.infrastructure.interfaces.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

        private final AuthenticationProvider authenticationProvider;
        private final JwtAuthenticationFilter jwtAuthFilter;
        private final AuthException exception;

        public SecurityConfig(
                        AuthenticationProvider authorize,
                        JwtAuthenticationFilter jwtAuthFilter,
                        AuthException exception) {
                this.authenticationProvider = authorize;
                this.jwtAuthFilter = jwtAuthFilter;
                this.exception = exception;
        }

        private final String[] publicRouter = {
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/api/v1/auth/**"
        };

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf(AbstractHttpConfigurer::disable)
                                .cors(AbstractHttpConfigurer::disable)
                                .httpBasic(Customizer.withDefaults())
                                .authorizeHttpRequests(authorize -> authorize.requestMatchers(publicRouter).permitAll().anyRequest().authenticated())
                                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                                .authenticationProvider(authenticationProvider)
                                .exceptionHandling(ex -> ex.authenticationEntryPoint(exception));
                return http.build();
        }

}
