package org.example.view;

import org.example.controller.DepartmentController;
import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DepartmentManagement extends JDialog {

    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartmentManagement dialog = new DepartmentManagement();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }

    public DepartmentManagement() {
        super();
        setTitle("Gestion des départements");
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        showDepartments(table);

    }

    private void showDepartments(JTable table) {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[2];
        for (Department department : departmentDAO.getAllDepartments()) {
            row[0] = department.getId();
            row[1] = department.getName();
            model.addRow(row);
        }
    }

    private void initComponents() {
        // initialisation
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JPanel footerPanel = new JPanel();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name"}));

        // Ajout des composants
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Name");
        }

        // Ajout des composants au footerPanel
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        getContentPane().add(scrollPane);


        // Bouton Ajouter
        JButton btnAdd = new JButton("Ajouter");
        btnAdd.setPreferredSize(new Dimension(120, 20));
        btnAdd.addActionListener(e -> {
            DepartmentUI insertDialog = new DepartmentUI();
            insertDialog.setVisible(true);
            setVisible(false);
        });

        // Bouton Supprimer
        JButton btnDelete = new JButton("Supprimer");
        btnDelete.setPreferredSize(new Dimension(120, 20));
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Merci de selectionner 1 département!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                long id = (long) table.getValueAt(row, 0);
                int response = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce département?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    DepartmentController departmentController = new DepartmentController();
                    departmentController.deleteDepartment(id);
                    JOptionPane.showMessageDialog(null, "Département supprimé!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    DepartmentManagement departmentManagement = new DepartmentManagement();
                    departmentManagement.setVisible(true);
                }
            }
        });

        // Bouton Retour
        JButton btnBack = new JButton("Retour");
        btnBack.setPreferredSize(new Dimension(120, 20));
        btnBack.addActionListener(e -> {
            setVisible(false);
            EmployeeManagement employeeManagement = new EmployeeManagement();
            employeeManagement.setVisible(true);
        });

        // Ajout des boutons au footerPanel
        footerPanel.add(btnAdd);
        footerPanel.add(btnDelete);
        footerPanel.add(btnBack);
    }
}
