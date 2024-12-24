package com.prod.order.config;

import com.prod.order.mapper.user.UserMapper;
import com.prod.order.model.user.User;
import com.prod.order.service.user.CustomUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SecurityConfigTest {

    @Test
    public void _암호확인(){
        String pw = "test";
        SecurityConfig security = new SecurityConfig(new CustomUserDetailService(new UserMapper() {
            @Override
            public User findByUsername(String username) {
                return null;
            }
        }));

        log.info("BCryptPasswordEncoder : {}", security.passwordEncoder().encode(pw));
    }
}