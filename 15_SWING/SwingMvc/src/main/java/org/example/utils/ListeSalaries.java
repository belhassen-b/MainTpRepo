package org.example.utils;

import org.example.controller.SalarieController;
import org.example.model.Salarie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListeSalaries {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Liste des salariés");
        frame.setContentPane(new ListeSalaries().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private SalarieController salarieController;
    private DefaultTableModel model;

    private SalarieTableModel salarieTableModel;

    public void listeSalaries(JTable table) {
        salarieController = new SalarieController();
        List<Salarie> salaries = salarieController.afficheSalaries();
        salarieTableModel = new SalarieTableModel(salaries);
        salarieTableModel.fireTableDataChanged();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Salarie salarie : salaries) {
            Object[] rowData = {
                    salarie.getId(),
                    salarie.getNom(),
                    salarie.getPrenom(),
                    salarie.getRole(),
                    salarie.getDepartement()
            };
            model.addRow(rowData);
        }
    }
}