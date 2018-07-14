package com.web.messenger.config;

import com.web.messenger.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;



@Configuration
@EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/login", "/error","/","/js/*","/css/*").permitAll()
                    .antMatchers("/faq","/user","/user/**").authenticated()
                    .and().exceptionHandling()
                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
            http.formLogin().usernameParameter("login").passwordParameter("password");
//            http.csrf().disable();
        }

        @Autowired
        private UserDetailServiceImpl userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth)
                throws Exception {
            auth.authenticationProvider(authenticationProvider());
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider
                    = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService);
            authProvider.setPasswordEncoder(encoder());
            return authProvider;
        }

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

    }