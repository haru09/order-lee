package com.prod.order.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean enabled;

    // Getters and Setters
}