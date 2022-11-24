package com.candidate.enums;

import lombok.Getter;

@Getter
public enum RoleType {
    USER("user"),
    ADMIN("admin");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }
}
