package org.example.model;

public enum Qualification {
    DOCTORAT ("Doctorat"),
    MASTER ("Master"),
    LICENCE ("Licence"),
    BAC ("Bac"),
    BAC_1 ("Bac+1"),

    BAC_2 ("Bac+2");


    private final String qualification;

    Qualification(String qualification) {
        this.qualification = qualification;
    }
}
