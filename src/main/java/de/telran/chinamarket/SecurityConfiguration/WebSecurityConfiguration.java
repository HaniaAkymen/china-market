package de.telran.chinamarket.SecurityConfiguration;

import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.repository.SecurityAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration for Web Security
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-02-03
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //отключение "банковской" защиты
                .cors(cors -> cors.disable()) //отключение защиты - информация только с одного домена (чтобы не внедрялся код в javascript)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/admin/****").hasRole("ADMIN");
                    request.requestMatchers("/customer/**").hasRole("CUSTOMER");
                    request.requestMatchers("/public/***").permitAll();
                    request.anyRequest().permitAll();
                })
                .formLogin(formLogin -> formLogin.disable())
                .httpBasic(httpBasic ->
                        httpBasic.init(http));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(SecurityAccountRepository securityAccountRepository) {
        UserDetailsService userDetailsService = (customer_email) -> {

            SecurityAccount securityAccount = securityAccountRepository.findByLogin(customer_email);
            if (securityAccount != null) {
                return securityAccount;
            } else {
                throw new UsernameNotFoundException("USER NOT FOUND");
            }
        };
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("berlin"));
        return bCryptPasswordEncoder;
    }
}
