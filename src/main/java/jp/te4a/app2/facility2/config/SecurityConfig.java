package jp.te4a.app2.facility2.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jp.te4a.app2.facility2.service.LoginUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private LoginUserDetailsService loginUserDetailsSrevice;
    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserDetailsSrevice).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.formLogin(login -> login
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .defaultSuccessUrl("/admin", true)
            .failureUrl("/login?error")
            .usernameParameter("username").passwordParameter("password")
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/login"))
            .authorizeHttpRequests(authz -> authz
            .requestMatchers("/webjars/**", "/css/**", "/js/**", "/image/**").permitAll()
            .requestMatchers("/login").permitAll()
            .requestMatchers("/auth").permitAll()
            .requestMatchers("/auth/create").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}
