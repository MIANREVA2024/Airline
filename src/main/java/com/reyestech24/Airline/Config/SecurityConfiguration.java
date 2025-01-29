package com.reyestech24.Airline.Config;
import static org.springframework.security.config.Customizer.withDefaults;

import com.reyestech24.Airline.security.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoint}")
    String endpoint;

    private JpaUserDetailsService jpaUserDetailsService;
    public SecurityConfiguration(JpaUserDetailsService userDetailsService) {
        this.jpaUserDetailsService = userDetailsService;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(endpoint).permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll()
                        .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN") // principio de mínimos
                        .requestMatchers(endpoint + "/public").permitAll()
                        .requestMatchers(endpoint + "/private").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/countries").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/countries").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(jpaUserDetailsService)
                .httpBasic(withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * @Bean
     * public InMemoryUserDetailsManager userDetailsManager() {
     *
     * UserDetails mickey = User.builder()
     * .username("mickey")
     * .password("{noop}mouse")
     * .roles("ADMIN")
     * .build();
     *
     * UserDetails minnie = User.builder()
     * .username("minnie")
     * .password("{noop}mouse")
     * .roles("USER")
     * .build();
     *
     * Collection<UserDetails> users = new ArrayList<>();
     * users.add(mickey);
     * users.add(minnie);
     *
     * return new InMemoryUserDetailsManager(users);
     * }
     */

}