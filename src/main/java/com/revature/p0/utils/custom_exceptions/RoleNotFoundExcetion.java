package com.revature.p0.utils.custom_exceptions;

public class RoleNotFoundExcetion extends RuntimeException {
    public RoleNotFoundExcetion() {
        super("Role not found!");
    }
}
