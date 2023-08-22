package com.example.demo;


import lombok.Data;

import javax.swing.*;
import java.awt.*;


@Data
public class GridBagLayoutDemo {


    private JButton button;
    private JPanel panel;

    GridBagLayout gridBagLayout = new GridBagLayout();


    public GridBagLayoutDemo(){

        gridBagLayout.columnWidths = new int[6];
        gridBagLayout.rowHeights = new int[6];

        panel = new JPanel();
        panel.setLayout(gridBagLayout);




        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3 ; j++) {

                JButton button = new JButton("B" + i + "X"+ j);
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = i;
                gridBagConstraints.gridy = j;
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                if(i == 0 && j == 0){
                    gridBagConstraints.gridwidth = 2;
                }
                if(i == 1 && j == 1){
                    gridBagConstraints.gridheight = 2;
                }
                panel.add(button,gridBagConstraints);
            }
        }






    }

}
