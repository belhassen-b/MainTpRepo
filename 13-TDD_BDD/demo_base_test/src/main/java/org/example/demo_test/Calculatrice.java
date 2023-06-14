package org.example.demo_test;

public class Calculatrice {

    public int addition(int a, int b) {
        return a + b;
    }

    public int division(int a, int b) {
     if(b!=0){
        return a / b;
     }
        else{
            throw new IllegalArgumentException("Division par zéro impossible");
}
        }
    }
