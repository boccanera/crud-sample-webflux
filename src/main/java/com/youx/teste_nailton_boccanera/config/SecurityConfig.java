package com.youx.teste_nailton_boccanera.config;

import com.youx.teste_nailton_boccanera.config.filter.JWTTokenGeneratorFilter;
import com.youx.teste_nailton_boccanera.config.filter.JWTTokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .and()
                .cors()
                .and()
                .authorizeHttpRequests((requests) -> requests
                .antMatchers(HttpMethod.POST,"/usuarios", "/login").permitAll()
                .anyRequest().authenticated())
                .formLogin().permitAll()
                .defaultSuccessUrl("/estados", true)
                .and().httpBasic()
                .and().csrf().disable()
                .addFilterBefore(new JWTTokenValidatorFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), UsernamePasswordAuthenticationFilter.class);
//               .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
//               .addFilterAt(new AuthoritiesLoggingAtFilter(),BasicAuthenticationFilter.class)
//               .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
        return http.build();
    }

    @Bean
    CorsConfiguration getCorsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setExposedHeaders(List.of("Authorization"));
        config.setMaxAge(3600L);
        return config;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
