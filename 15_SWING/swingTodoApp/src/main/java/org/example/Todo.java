package org.example;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class Todo {

    private JFrame frame;
    private JPanel headerPanel;
    private JPanel listPanel;
    private JPanel footerPanel;

    private JTextField taskInput;

    private JButton addButton;
    private JButton deleteButton;
    private JButton completeButton;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JScrollPane scrollPane;


    public Todo() {

        frame = new JFrame("To-do List App");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        headerPanel = new JPanel();
        headerPanel.setBackground(Color.white);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        headerPanel.setPreferredSize(new Dimension(600, 40));


        listPanel = new JPanel();
        listPanel.setPreferredSize(new Dimension(600, 400));
        listPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#303030"), 1));

        footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#303030"));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        taskInput = new JTextField();
        taskInput.setPreferredSize(new Dimension(585, 25));
        taskInput.setFont(new Font("Roboto", Font.PLAIN, 20));


// Gestion des icones

        ImageIcon plusIcon = new ImageIcon("./src/main/resources/images/plus_icon.png");
        plusIcon.setImage(plusIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        ImageIcon deleteIcon = new ImageIcon("./src/main/resources/images/delete_icon.png");
        deleteIcon.setImage(deleteIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        ImageIcon completeIcon = new ImageIcon("./src/main/resources/images/complete_icon.png");
        completeIcon.setImage(completeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));


        // Gestion des boutons
        addButton = new JButton("Add", plusIcon);
        addButton.setPreferredSize(new Dimension(100, 30));
        deleteButton = new JButton("Delete", deleteIcon);
        completeButton = new JButton("Complete", completeIcon);


// Gestion de la liste de tâches

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setForeground(Color.decode("#303030"));
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setFont(new Font("Roboto", Font.PLAIN, 20));
        list.setPreferredSize(new Dimension(585, 360));

        headerPanel.add(taskInput);


// gestion des panels

        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JScrollPane(list));

        footerPanel.add(addButton);
        footerPanel.add(deleteButton);
        footerPanel.add(completeButton);

// Ajout des panels dans le frame

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(list, BorderLayout.WEST);
        frame.add(footerPanel, BorderLayout.SOUTH);


// Mise en place des actions des boutons

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (task.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Merci d'entrer une tâche");
                } else {

                    listModel.addElement("<html><font color='orange' bold>" + task + "</font></html>");
                    taskInput.setText("");
                }
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Sélectionnez une tâche à supprimer");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String task = listModel.getElementAt(selectedIndex);
                    if (task.contains("<html><font color='orange' bold>")) {
                        listModel.setElementAt(task.replace("<html><font color='orange' bold>", "<html><font color='green' strikethrough>"), selectedIndex);
                    } else {
                        listModel.setElementAt(task.replace("<html><font color='green' strikethrough>", "<html><font color='orange' bold>"), selectedIndex);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Sélectionnez une tâche à compléter");
                }
            }
        });


        frame.setVisible(true);
    }
}
