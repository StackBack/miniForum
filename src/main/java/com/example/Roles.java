package com.example;

public enum Roles {
    USER, ADMIN, DEVELOPER;


    @Override
    public String toString() {
        return "ROLE: " + name();
    }
}
