package com.astontech.hr.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

/**
 * Created by Bipin on 3/24/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    final static String AUTH_METHOD = "IN_MEMORY";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        if(AUTH_METHOD.equals("NONE")) {

        } else if(AUTH_METHOD.equals("LDAP")){

            auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());

        } else if(AUTH_METHOD.equals("IN_MEMORY")){

            auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
            auth.inMemoryAuthentication().withUser("dba").password("123").roles("DBA");

        }
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        if(AUTH_METHOD.equals("NONE")) {

            httpSecurity
                    .authorizeRequests().antMatchers("/").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/console/**").permitAll();

        } else if(AUTH_METHOD.equals("LDAP")){

            httpSecurity
                    .authorizeRequests().antMatchers("/static/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/login**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                    .defaultSuccessUrl("/").failureUrl("/login?err=1")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                    .logout()
                    .and()
                    .rememberMe();


        } else if(AUTH_METHOD.equals("IN_MEMORY")){

            httpSecurity

                    .authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .and()
                    .authorizeRequests().antMatchers("/console/**").access("hasRole('ROLE_DBA')")
                    .and()
                            //custom login form
                    .formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                    .defaultSuccessUrl("/", true).failureUrl("/login?err=1")
                    .usernameParameter("username")
                    .passwordParameter("password");

        }

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

    }


    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider authenticationProvider =
                new ActiveDirectoryLdapAuthenticationProvider("aston.prod.com", "ldap://10.162.249.30:389");

        authenticationProvider.setConvertSubErrorCodesToExceptions(true);
        authenticationProvider.setUseAuthenticationRequestCredentials(true);

        return authenticationProvider;
    }
}
