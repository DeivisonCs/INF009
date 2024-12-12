package com.library.library.dto.enums;

public enum Roles {
    ADMIN("admin_user"),
    COMMON("common_user");

    private final String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

    public static final String ADMIN_ROLE = "admin_user";
    public static final String COMMON_ROLE = "common_user";

}
