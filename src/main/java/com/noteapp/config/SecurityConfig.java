package com.noteapp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;

import static javax.servlet.http.HttpServletRequest.BASIC_AUTH;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }


    @Bean(name = BeanIds.USER_DETAILS_SERVICE)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and()
                .requestCache().and()

                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()

                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/node_modules/**").permitAll()
                .antMatchers("/app/components/users/**").permitAll()
                .anyRequest().authenticated().and()
//                .antMatchers("/app/components/assets/**").hasAuthority("ROLE_USER").and()
                .logout().logoutUrl("/logout").and()
                .rememberMe().key("uniqueAndSecret");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
        System.out.println("1");
        authenticationManagerBean();

//        authenticationManager();
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    }






}
