package org.example.view;

import org.example.controller.DepartmentController;
import org.example.model.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DepartmentManagement extends JDialog {

    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartmentManagement dialog = new DepartmentManagement();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }

    public DepartmentManagement() {
        super();
        setTitle("Department Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        showDepartments(table);

    }

    private void showDepartments(JTable table) {
        DepartmentController departmentController = new DepartmentController();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[2];
        for (Department department : departmentController.getAllDepartments()) {
            row[0] = department.getId();
            row[1] = department.getName();
            model.addRow(row);
        }
    }

    private void initComponents() {

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name"}));

        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Name");
        }

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(footerPanel, BorderLayout.SOUTH);

        getContentPane().add(scrollPane);

        JButton btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(120, 20));
        btnAdd.addActionListener(e -> {
            DepartmentUI insertDialog = new DepartmentUI();
            insertDialog.setVisible(true);
            setVisible(false);

        });

        footerPanel.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(120, 20));
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                long id = (long) table.getValueAt(row, 0);
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the employee?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    DepartmentController departmentController = new DepartmentController();
                    departmentController.deleteDepartment(id);
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    DepartmentManagement departmentManagement = new DepartmentManagement();
                    departmentManagement.setVisible(true);
                }
            }
        });

        footerPanel.add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(120, 20));
        btnBack.addActionListener(e -> {
            setVisible(false);
            EmployeeManagement employeeManagement = new EmployeeManagement();
            employeeManagement.setVisible(true);
        });
        footerPanel.add(btnBack);
    }


}
