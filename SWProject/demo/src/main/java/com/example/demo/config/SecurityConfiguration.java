package com.example.demo.config;


// import jakarta.annotation.Nonnull;
// import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration  {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private  final  AuthenticationProvider authenticationProvider;

    //to solve error
    // public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
    //     this.jwtAuthFilter = jwtAuthFilter;
    //     this.authenticationProvider = authenticationProvider;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
    http
                  .csrf((e)->e.disable())
                  .authorizeHttpRequests( authorizeRequest ->
                          authorizeRequest
                                  .requestMatchers("api/v1/auth/**")
                                  .permitAll()
                                  .anyRequest()
                                  .authenticated()

                                 )


                 .sessionManagement((session) -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                       )


                  .authenticationProvider(authenticationProvider)
                  .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class);




return http.build();
}
}
