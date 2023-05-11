package org.example;

import org.example.ihm.IHM;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IHM ihm = new IHM();
        ihm.start();
    }
}