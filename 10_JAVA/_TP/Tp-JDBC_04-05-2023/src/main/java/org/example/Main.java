package org.example;

import jdk.jshell.spi.ExecutionControl;
import tpJDBC2.ihm.IHM;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ExecutionControl.NotImplementedException {

        IHM ihm = new IHM();
        ihm.start();
    }
}