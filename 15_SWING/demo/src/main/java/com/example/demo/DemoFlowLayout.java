package com.example.demo;


import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class DemoFlowLayout {

    JPanel jpanel  = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));


    public DemoFlowLayout(){

        jpanel.add(new JButton("Button 1"));
        jpanel.add(new JButton("Button 2"));
        jpanel.add(new JButton("Button 3"));

    }

}

