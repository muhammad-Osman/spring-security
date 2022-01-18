package com.self.section2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurity extends WebSecurityConfigurerAdapter {
    /*
        /account - secured
        /balance - secured
        /cards   - secured
        /loans   - secured
        /contact - not secured
        /notices - not secured
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/account/").authenticated()
                .antMatchers("/balance/").authenticated()
                .antMatchers("/cards/").authenticated()
                .antMatchers("/loans/").authenticated()
                .antMatchers("/contact/").permitAll()
                .antMatchers("/notices/").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

}
