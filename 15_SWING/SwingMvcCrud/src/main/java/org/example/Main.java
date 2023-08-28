package org.example;

import org.example.view.EmployeeManagement;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagement dialog = new EmployeeManagement();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
    });
    }
}