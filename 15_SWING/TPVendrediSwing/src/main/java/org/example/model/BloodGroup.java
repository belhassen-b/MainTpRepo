package org.example.model;

public enum BloodGroup {

    A_POSITIF ("A+"),
    A_NEGATIF("A-"),
    B_POSITIF("B+"),
    B_NEGATIF("B-"),
    O_POSITIF("O+"),
    O_NEGATIF("O-"),
    AB_POSITIF("AB+"),
    AB_NEGATIF("AB-");

    private final String bloodGroup;

    BloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


}
