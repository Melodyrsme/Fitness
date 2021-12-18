package com.company.fitnessproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT t.login, t.password, t.is_active FROM users t WHERE t.login = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.login, r.name_role " +
                                "FROM role_user ru " +
                                "INNER JOIN users u " +
                                "   on ru.user_id = u.id " +
                                "INNER JOIN roles r " +
                                "   on ru.role_id = r.id " +
                                "WHERE u.login = ? AND u.is_active = 1"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "api/user/*").permitAll()
                .antMatchers(HttpMethod.GET, "api/user/*").hasRole("USER")

                .antMatchers(HttpMethod.POST, "api/gym/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "api/gym/*").hasRole("USER")

                .antMatchers(HttpMethod.POST, "api/user-date/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "api/user-date/*").hasRole("USER")

                .antMatchers(HttpMethod.POST, "api/subscription/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "api/subscription/*").hasRole("USER")

                .and()
                .httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
