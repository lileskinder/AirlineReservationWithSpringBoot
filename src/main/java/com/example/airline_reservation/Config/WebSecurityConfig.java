package com.example.airline_reservation.Config;

import com.example.airline_reservation.security.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private static final String USERNAME_QUERY = "SELECT P.UserName, R.Password, 1  enabled"
//            + "  FROM Person P "
//            + "  INNER JOIN Role R ON P.ID = R.PERSONID "
//            + "  WHERE P.UserName = ?";
//
//    private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT P.UserName as principal, R.Role as role"
//            + "  FROM Person P "
//            + "  INNER JOIN Role R ON P.ID = R.PERSONID "
//            + "  WHERE P.UserName = ?";
//

    //    private final DataSource dataSource;
//
//    @Autowired
//    public WebSecurityConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    private final ApplicationUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(ApplicationUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

//
//    @Autowired
//    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.jdbcAuthentication()
//                .passwordEncoder(encoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(USERNAME_QUERY)
//                .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/agents/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/admins/**").permitAll()
                .antMatchers("/agents/**").permitAll()
                .antMatchers("/passengers/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
