package com.revature.p0.models;

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

    public void setSession(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        // this.roleId = user.getRoleId();
        this.email = user.getEmail();
    }
}
