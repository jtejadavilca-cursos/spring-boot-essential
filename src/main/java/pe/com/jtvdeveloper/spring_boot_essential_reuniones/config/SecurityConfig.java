package pe.com.jtvdeveloper.spring_boot_essential_reuniones.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/*").hasRole("API_USER")
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails userOne = User.builder().username("usuario")
                .password(passwordEncoder().encode("Aa123456."))
                .roles("API_USER", "USER").build();
        UserDetails userTwo = User.builder().username("newuser")
                .password(passwordEncoder().encode("Aa123456."))
                .roles("USER").build();


        return new InMemoryUserDetailsManager(userOne, userTwo);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
