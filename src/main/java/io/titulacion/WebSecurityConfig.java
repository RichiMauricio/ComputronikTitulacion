package io.titulacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;
//import javax.activation.DataSource;

/**
 * Created by Mauricio on 27/12/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /*@Autowired
    private UserDetailsService userDetailsService;*/

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login.html")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
        /*auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
                .and()
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(sqlUserName)
                .authoritiesByUsernameQuery(sqlAuthorities);
                */
        .inMemoryAuthentication()
                .withUser("richi").password("richi").roles("ADMIN");
    }

    /*@Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
}
