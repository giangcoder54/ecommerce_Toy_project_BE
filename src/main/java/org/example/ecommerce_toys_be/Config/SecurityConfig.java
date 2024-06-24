package org.example.ecommerce_toys_be.Config;

import org.example.ecommerce_toys_be.Security.JWT.AuthenticationEntryPointHandler;
import org.example.ecommerce_toys_be.Security.JWT.AuthenticationFilter;
import org.example.ecommerce_toys_be.Security.UserDetailsImpl;
import org.example.ecommerce_toys_be.Security.UserDetailsImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity //cho phép Spring tìm và tự động áp dụng class này là global Web security.
@Configuration
@EnableGlobalMethodSecurity //Cho phép inject 2 annotation là @PreAuthorize và @PostAuthorize trên các phương cần bảo về quyền hạn truy cập.
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
//        Logger logger = LoggerFactory.getLogger(this.getClass());

        @Autowired
        UserDetailsImplService userDetailsService;

        @Autowired
        private AuthenticationEntryPointHandler unauthorizedHandler;

        @Bean
        public AuthenticationFilter authenticationJwtTokenFilter() {
                return new AuthenticationFilter();
        }

        @Override
        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
                authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

        // Configuring HttpSecurity
        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()
                        .authorizeRequests(requests -> requests
                                .antMatchers("/api/auth/**").permitAll()
                                )
                        .formLogin(login -> login
                                .loginPage("/login")
                                .loginProcessingUrl("/do-login")
                                .defaultSuccessUrl("/index"))
                        .logout(logout -> logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout")
                                .permitAll());
        }

        // Password Encoding
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}

