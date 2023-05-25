package com.revature.p0.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String roles;
    private String email;

    public User(String username, String password, Roles foundRole) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }
}
