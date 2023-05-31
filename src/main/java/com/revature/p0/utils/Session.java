package com.revature.p0.utils;

import com.revature.p0.models.User;

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
public class Session {
    private String id;
    private String username;
    private String roleId;
    private String email;
    // private User user;

    public void setSession(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roleId = user.getRoleId();

        // System.out.println("================ID: " + this.id);
    }

    public boolean isLoggedIn() {
        return id != null;
    }

    // public String getId() {
    // System.out.println("================ID: " + this.id);
    // return this.id;
    // }
}
