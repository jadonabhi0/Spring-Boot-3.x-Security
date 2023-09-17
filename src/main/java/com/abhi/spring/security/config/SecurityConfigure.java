package com.abhi.spring.security.config;/*
    @author jadon
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {


    @Bean
    public SecurityFilterChain springSecurityConfigure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(
                        (auth->{auth.disable();})
                )
                .authorizeHttpRequests((auth)->
                        auth
                                .requestMatchers("/public/**")
                                .permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasRole("USER")
                                .anyRequest()
                                .authenticated()

                )
                .formLogin(
                        (auth)->{
                            auth.defaultSuccessUrl("/public/home");
                        }
                );


        return httpSecurity.build();
    }



    // configuring in-memory user

    @Bean
    public UserDetailsService userDetailsService (){

        UserDetails adminUser = User
                        .withUsername("Abhishek")
                        .password(passwordEncoder().encode("abc"))
                        .roles("ADMIN")
                        .build();

        UserDetails normalUser = User
                .withUsername("Aman")
                .password(passwordEncoder().encode("abc"))
                .roles("USER")
                .build();


        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(adminUser, normalUser);
        return  manager;

    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
