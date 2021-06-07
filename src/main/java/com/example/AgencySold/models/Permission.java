package com.example.AgencySold.models;

public enum Permission {
    DEVELOPERS_READ("admins:read"),
    DEVELOPERS_WRITE("admins:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}