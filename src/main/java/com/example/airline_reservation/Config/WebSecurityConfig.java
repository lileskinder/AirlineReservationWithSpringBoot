package com.example.airline_reservation.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USERNAME_QUERY = "SELECT P.UserName, R.Password, 1  enabled"
            + "  FROM Person P "
            + "  INNER JOIN Role R ON P.ID = R.PERSONID "
            + "  WHERE P.UserName = ?";

    private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT P.UserName, R.Role"
            + "  FROM Person P "
            + "  INNER JOIN Role R ON P.ID = R.PERSONID "
            + "  WHERE P.UserName = ?";

    @Autowired
    private DataSource dataSource;

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("Admin")
//                //.password(encoder.encode("123"))
//                .password("123")
//                .roles("Admin");

        auth.jdbcAuthentication()
                .passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(USERNAME_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/admins/**").hasAnyRole("Admin")
                .antMatchers("/agents/**").hasAnyRole("Agents", "Admin")
                .antMatchers("/passengers/**").hasAnyRole("Passengers", "Agents", "Admin")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
