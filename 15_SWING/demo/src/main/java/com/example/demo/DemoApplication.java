package com.example.demo;



import javax.swing.*;

public class DemoApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame frame=new JFrame("DemoLayout");
              frame.setSize(300,600);
            frame.setContentPane(new demoBorderLayout().getPanel1());

//            frame.setContentPane(new GridBagLayoutDemo().getPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

            }
        });
    }
}
