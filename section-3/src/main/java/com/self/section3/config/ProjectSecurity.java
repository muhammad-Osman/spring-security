package com.self.section3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

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

    // One way to use InMemoryAuthentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("12345").authorities("admin")
//                .and()
//                .withUser("user")
//                .password("user").authorities("read")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("admin").password("admin").authorities("admin").build();
        UserDetails user2 = User.withUsername("user").password("user").authorities("user").build();
        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        auth.userDetailsService(userDetailsService);
    }*/

    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
