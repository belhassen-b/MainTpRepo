package org.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {

 EMPLOYEE("EMPLOYEE"),
    MANAGER("MANAGER"),

    ADMIN("ADMIN");

    private final String value;

    public String getValue() {
        return value;
    }

}
