package com.prod.order.service.user;

import com.prod.order.model.user.User;
import com.prod.order.mapper.user.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    public CustomUserDetailService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // 암호화된 비밀번호
                .roles(user.getRole().replace("ROLE_", "")) // "ROLE_ADMIN" -> "ADMIN"
                .disabled(!user.isEnabled())
                .build();
    }
}
