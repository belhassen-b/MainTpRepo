package org.example;

import org.example.ihm.IHM;
import jdk.jshell.spi.ExecutionControl;


public class Main {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        IHM ihm = new IHM();
        ihm.start();
    }
}