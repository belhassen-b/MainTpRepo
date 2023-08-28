package org.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {

    EMPLOYE("EMPLOYE"),

    MANAGER("MANAGER"),

    RH("RH"),

    ADMIN("ADMIN");

    private final String value;

    public String getValue() {
        return value;
    }

}
