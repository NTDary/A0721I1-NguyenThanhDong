package com.codegym.loginformsecurity.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345").roles("USER")
                .and()
                .withUser("admin").password("{noop}12345").roles("ADMIN");
        //{noop} de ma hoa
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/").permitAll()
                .and()//hasAnyRole - set them nhieu role
                .authorizeRequests().antMatchers("/user**").hasAnyRole("USER","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }



        public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
    }

}
