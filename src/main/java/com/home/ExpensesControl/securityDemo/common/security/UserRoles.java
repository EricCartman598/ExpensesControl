package com.home.ExpensesControl.securityDemo.common.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.home.ExpensesControl.securityDemo.common.security.UserPermission.*;

public enum UserRoles {
    ADMIN(Sets.newHashSet(READ, WRITE, OTHER)),
    MANAGER(Sets.newHashSet(READ, WRITE)),
    USER(Sets.newHashSet(READ));

    private final Set<UserPermission> userPermission;

    UserRoles(Set<UserPermission> userPermission) {
        this.userPermission = userPermission;
    }
}
