package com.travelGuide.GuideWeb.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,OAuth2SuccessHandler oAuth2SuccessHandler){
        this.jwtAuthenticationFilter=jwtAuthenticationFilter;
        this.oAuth2SuccessHandler=oAuth2SuccessHandler;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

                 http

                .csrf(csrf -> csrf.disable())
                         .cors(cors -> {})
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**","/user/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/trip/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST,"/trip/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/trip/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/trip/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/booking/approved/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/booking/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers( "/review/**").permitAll()
                        .anyRequest().authenticated()
                ).oauth2Login(oauth -> oauth
                .successHandler(oAuth2SuccessHandler))

                .sessionManagement(
                        session->session
                                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
