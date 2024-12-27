package com.prod.order.config;

import com.prod.order.service.user.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailService userDetailService;

    public SecurityConfig(CustomUserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // 비밀번호 암호화
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// CSRF(Cross-Site Request Forgery) 보호 비활성화. REST API에서 주로 사용.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/static/**").permitAll() // 모두 접근 가능
                        .requestMatchers("/", "/login", "/register", "/product/**").permitAll()  // 모두 접근 가능
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // 관리자만 접근 가능
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login")     // 사용자 정의 로그인 페이지
                        .defaultSuccessUrl("/", true)  // 로그인 성공 후 리다이렉트
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")   // 로그아웃 후 이동
                        .permitAll()
                );

        return http.build();
    }
}
