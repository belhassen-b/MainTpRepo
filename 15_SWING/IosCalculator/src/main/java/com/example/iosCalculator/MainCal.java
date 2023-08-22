package com.example.iosCalculator;


import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class MainCal extends JFrame {

    private Container container = getContentPane();

    private JLabel screen = new JLabel();
    private JPanel panel, panel2;
    String[] buttons = {"C", "+/-", "%", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", "",".", "="};
    JButton[] tab_button = new JButton[buttons.length];


    private JButton button1;
    private double num1;
    private double num2;
    private double result;
    private String operator = "";
    private boolean operatorClicked = false;
    private boolean update = false;


    public void calculator() {

        this.setTitle("Calculator");
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
        initComponent();

    }

    private void initComponent() {

        // set font for screen
        Font font = new Font("Arial", Font.TRUETYPE_FONT, 55);
        screen.setFont(font);
        screen.setHorizontalAlignment(JLabel.RIGHT);
        screen.setPreferredSize(new Dimension(380, 160));
        screen.setVerticalAlignment(JLabel.BOTTOM);
        screen.setForeground(Color.WHITE);
        screen.setBackground(Color.black);
        screen.setOpaque(true);


        JPanel panel = new JPanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
//        panel.setBackground(Color.darkGray);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        for (int i = 0; i < buttons.length; i++) {
            tab_button[i] = new JButton(buttons[i]);
            tab_button[i].setFont(new Font("Arial", Font.TRUETYPE_FONT, 25));
            tab_button[i].setForeground(Color.GRAY);
            tab_button[i].setBackground(Color.LIGHT_GRAY);
            tab_button[i].setPreferredSize(new Dimension(70, 70));
            tab_button[i].setFocusable(false);

            switch (i) {
                case 0:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            screen.setText("");
                            num1 = 0;
                            operator = "";
                            operatorClicked = false;
                            update = false;
                        }
                    });
                    break;
                case 1:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double temp = Double.parseDouble(screen.getText());
                            temp *= -1;
                            screen.setText(String.valueOf(temp));
                        }
                    });
                    break;
                case 2:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double temp = Double.parseDouble(screen.getText());
                            temp *= 0.01;
                            screen.setText(String.valueOf(temp));
                        }
                    });
                    break;

                case 3:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            num1 = Double.parseDouble(screen.getText());
                            operator = "/";
                            operatorClicked = true;
                            update = true;
                        }
                    });
                    break;

                case 4:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("7");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "7");
                            }
                        }
                    });
                    break;

                case 5:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("8");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "8");
                            }
                        }
                    });
                    break;

                case 6:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("9");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "9");
                            }
                        }
                    });
                    break;

                case 7:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            num1 = Double.parseDouble(screen.getText());
                            operator = "x";
                            operatorClicked = true;
                            update = true;
                        }
                    });
                    break;

                case 8:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("4");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "4");
                            }
                        }
                    });
                    break;

                case 9:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("5");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "5");
                            }
                        }
                    });
                    break;

                case 10:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("6");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "6");
                            }
                        }
                    });
                    break;

                case 11:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            num1 = Double.parseDouble(screen.getText());
                            operator = "-";
                            operatorClicked = true;
                            update = true;
                        }
                    });
                    break;


                case 12:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("1");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "1");
                            }
                        }
                    });
                    break;

                case 13:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("2");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "2");
                            }
                        }
                    });
                    break;

                case 14:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("3");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "3");
                            }
                        }
                    });
                    break;

                case 15:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            num1 = Double.parseDouble(screen.getText());
                            operator = "+";
                            operatorClicked = true;
                            update = true;
                        }
                    });
                    break;

                case 16:

                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (update) {
                                screen.setText("0");
                                update = false;
                            } else {
                                screen.setText(screen.getText() + "0");
                            }
                        }
                    });
                    break;

                case 17:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!screen.getText().contains(".")) {
                                screen.setText(screen.getText() + ".");
                            }
                        }
                    });
                    break;

                case 18:
                    tab_button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            num2 = Double.parseDouble(screen.getText());
                            switch (operator) {
                                case "+":
                                    result = num1 + num2;
                                    screen.setText(String.valueOf(result));
                                    break;
                                case "-":
                                    result = num1 - num2;
                                    screen.setText(String.valueOf(result));
                                    break;
                                case "x":
                                    result = num1 * num2;
                                    screen.setText(String.valueOf(result));
                                    break;
                                case "/":
                                    result = num1 / num2;
                                    screen.setText(String.valueOf(result));
                                    break;
                            }
                            update = true;
                        }
                    });
                    break;

            }
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            gridBagConstraints.gridx = i % 4;
            gridBagConstraints.gridy = i / 4 + 1;
            gridBagConstraints.gridwidth = 1;

            if (i == 16) {
                gridBagConstraints.gridwidth = 2;
            }


            panel.add(tab_button[i], gridBagConstraints);
        }
        panel.add(screen, gridBagConstraints);

// for buttun1 to button 4 set color orange
        tab_button[3].setBackground(Color.ORANGE);
        tab_button[7].setBackground(Color.ORANGE);
        tab_button[11].setBackground(Color.ORANGE);
        tab_button[15].setBackground(Color.ORANGE);
        tab_button[19].setBackground(Color.ORANGE);

        tab_button[3].setForeground(Color.WHITE);
        tab_button[7].setForeground(Color.WHITE);
        tab_button[11].setForeground(Color.WHITE);
        tab_button[15].setForeground(Color.WHITE);
        tab_button[19].setForeground(Color.WHITE);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.darkGray);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.add(screen);

        this.add(panel2, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);

    }
}





