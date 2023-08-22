package com.example;





import com.example.iosCalculator.MainCal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                    MainCal mainCal = new MainCal();
                    mainCal.calculator();
                    mainCal.setVisible(true);


            }
        });
    }
}