package org.example;

import org.example.ihm.Ihm;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Ihm ihm = new Ihm();
        ihm.start();
    }
}