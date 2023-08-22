package com.example.demo;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Data

public class GridLayoutDemo {
    private JPanel contentPane;


    public GridLayoutDemo() {
        JPanel panel = new JPanel(new GridLayout(3,3));

        for (int i, j = 0; j < 9; j++) {
            i = j + 1;
            JButton button = new JButton("Button " + i);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    JOptionPane.showMessageDialog(null, "You clicked on button " + finalI);
                    System.out.println(((JButton)e.getSource()).getText());
                }
            });
            panel.add(button);
        }

        contentPane = new JPanel(new BorderLayout());

        contentPane.add(panel, BorderLayout.CENTER);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new JFrame("DemoLayout");
                frame.setSize(300,600);
                frame.setContentPane(new GridLayoutDemo().getContentPane());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}