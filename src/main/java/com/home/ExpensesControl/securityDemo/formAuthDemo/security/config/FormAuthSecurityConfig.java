package com.home.ExpensesControl.securityDemo.formAuthDemo.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.home.ExpensesControl.securityDemo.common.security.UserRoles.*;

@Configuration
@Profile("formAuth")
public class FormAuthSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${security.admin.password}")
    private CharSequence ADMIN_PASSWORD;
    @Value("${security.manager.password}")
    private CharSequence MANAGER_PASSWORD;
    @Value("${security.user.password}")
    private CharSequence USER_PASSWORD;
    private final PasswordEncoder passwordEncoder;

    public FormAuthSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .requiresChannel()
//                .antMatchers("/login")
//                .requiresSecure()
//                .and()
                .authorizeRequests()
                .antMatchers("/", "/index", "/jspDemo")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode(ADMIN_PASSWORD))
                .roles(ADMIN.name())
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode(MANAGER_PASSWORD))
                .roles(MANAGER.name())
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode(USER_PASSWORD))
                .roles(USER.name())
                .build();
        return new InMemoryUserDetailsManager(admin, manager, user);
    }
}
