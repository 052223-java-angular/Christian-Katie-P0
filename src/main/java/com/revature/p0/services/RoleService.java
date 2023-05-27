package com.revature.p0.services;

import java.util.Optional;

import javax.management.relation.RoleNotFoundException;

import com.revature.p0.daos.RoleDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.Role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleService {
    private final RoleDAO roleDAO;

    public Role findByName(String name) {
        Optional<Role> roleOpt = roleDAO.findByName(name);

        if (roleOpt.isPresent()) {
        }
        return roleOpt.get();
    }

    /*--------------------Helper Method--------------------- */

    private UserService getUserService() {
        return new UserService(new UserDAO(), getRoleService());
    }

    private RoleService getRoleService() {
        return new RoleService(new RoleDAO());
    }
}
