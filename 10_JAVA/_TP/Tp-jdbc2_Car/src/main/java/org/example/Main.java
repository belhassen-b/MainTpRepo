package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.example.ihm.IHM;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ExecutionControl.NotImplementedException {
        IHM ihm = new IHM();
        ihm.start();
    }
}