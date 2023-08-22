package com.example.demo;


import lombok.Data;

import javax.swing.*;
import java.awt.*;


@Data
public class demoBorderLayout {

    private JPanel panel1;

    private JButton button;

    private JButton button1;

    private JButton button2;

    private JButton button3;

    private JButton button4;

    public demoBorderLayout() {
    panel1 = new JPanel( new BorderLayout());
    button = new JButton("North");
    button1 = new JButton("South");
    button2 = new JButton("East");
    button3 = new JButton("West");
    button4 = new JButton("Center");

    button.setForeground(Color.RED);
    button1.setForeground(Color.BLUE);
    button2.setForeground(Color.GREEN);
    button3.setForeground(Color.YELLOW);
    button4.setForeground(Color.BLACK);

    button.setBackground(Color.GREEN);
    button1.setBackground(Color.WHITE);
    button2.setBackground(Color.YELLOW);
    button3.setBackground(Color.CYAN);
    button4.setBackground(Color.red);


    panel1.add(button, BorderLayout.NORTH);
    panel1.add(button1, BorderLayout.SOUTH);
    panel1.add(button2, BorderLayout.EAST);
    panel1.add(button3, BorderLayout.WEST);
    panel1.add(button4, BorderLayout.CENTER);





    }

}
