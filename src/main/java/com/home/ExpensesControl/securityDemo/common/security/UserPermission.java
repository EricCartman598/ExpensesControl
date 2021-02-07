package com.home.ExpensesControl.securityDemo.common.security;

public enum UserPermission {
    WRITE("Write only"),
    READ("Read only"),
    OTHER("Other actions");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
