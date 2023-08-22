package com.example.demo;


import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame frame=new JFrame("CardLayout");
            frame.setSize(400,400);
            frame.setBackground(Color.CYAN);
            frame.setContentPane(new DemoFlowLayout().getJpanel());

            JPanel buttonPanel = new JPanel();
            JPanel cardPanel = new JPanel(new CardLayout());

            JButton button1 = new JButton("Card 1");
            JButton button2 = new JButton("Card 2");

            JPanel card1 = new JPanel();
            JPanel card2 = new JPanel();

            CardLayout cardLayout = new CardLayout();
            cardPanel.setLayout(cardLayout);

            card1.setBackground(Color.RED);
            card1.add(new Label("Card 1"));

            card2.setBackground(Color.BLUE);
            card2.add(new Label("Card 2"));

            cardPanel.add(card1, "Card 1");
            cardPanel.add(card2, "Card 2");

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "Card 1");
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "Card 2");
                }
            });

            buttonPanel.add(button1);
            buttonPanel.add(button2);

            frame.setLayout(new BorderLayout());
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.add(cardPanel, BorderLayout.CENTER);


            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            }
        });
    }


}
