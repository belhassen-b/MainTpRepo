package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.example.ihm.IHM;


public class Main {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
      IHM IHM = new IHM();
        IHM.start();
    }
}