package io.titulacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;
//import javax.activation.DataSource;

/**
 * Created by Mauricio on 27/12/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                //.formLogin()
                //.loginPage("/login.html")
                //.permitAll()
            //.and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
            //.and()
                //.logout()
                //.logoutSuccessUrl("/index.html");
                //.permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //@Autowired
        //DataSource dataSource;

        //final String sqlUserName = "select u.usrEmail, u.usrId from usuario u where u.usrEmail = ?";
        //final String sqlAuthorities = "select ur.usrEmail, ur.fkEmpPerfil from empleado ur where ur.usrEmail = ?";
        /*auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
                .and()
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(sqlUserName)
                .authoritiesByUsernameQuery(sqlAuthorities);
                .inMemoryAuthentication()
                .withUser("richi").password("richi").roles("ADMIN");*/
    }
}
