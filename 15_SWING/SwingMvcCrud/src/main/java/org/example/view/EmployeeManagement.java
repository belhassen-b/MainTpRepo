package org.example.view;

import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.utils.EmployeeEditDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


import static org.example.utils.ShowEmployee.showEmployees;


public class EmployeeManagement  extends JDialog {

    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagement dialog = new EmployeeManagement();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }

    public EmployeeManagement() {
            super();
        setTitle("Employee Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        showEmployees(table);

    }

    private void initComponents() {

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name", "Last Name", "Role", "Department"}));


        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Name");
            table.getColumnModel().getColumn(2).setHeaderValue("Last Name");
            table.getColumnModel().getColumn(3).setHeaderValue("Role");
            table.getColumnModel().getColumn(4).setHeaderValue("Department");
        }

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(footerPanel, BorderLayout.SOUTH);


        getContentPane().add(scrollPane);

        JButton btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(120, 20));
        btnAdd.addActionListener(e -> {
            EmployeeUI insertDialog = new EmployeeUI();
            insertDialog.setVisible(true);
            setVisible(false);

        });

        footerPanel.add(btnAdd);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setPreferredSize(new Dimension(120, 20));
        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                long id = Integer.parseInt(table.getValueAt(row, 0).toString());
                EmployeeController employeeController = new EmployeeController();
                Employee employee = employeeController.getEmployee(id);

                if (employee != null) {
                    openEditDialog(employee);
                    setVisible(false);
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    employeeManagement.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error fetching employee data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        

        footerPanel.add(btnEdit);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(120, 20));
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the employee?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    EmployeeController employeeController = new EmployeeController();
                    employeeController.deleteEmployee((long) id);
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    employeeManagement.setVisible(true);
                }
            }
        });

        footerPanel.add(btnDelete);

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setPreferredSize(new Dimension(120, 20));
        btnDepartment.addActionListener(e -> {
            DepartmentManagement departmentDialog = new DepartmentManagement();
            departmentDialog.setVisible(true);
            setVisible(false);

        });

        footerPanel.add(btnDepartment);

    }

    private void openEditDialog(Employee employee) {
        // Create and show the edit dialog, passing the employee data
        EmployeeEditDialog editDialog = new EmployeeEditDialog(this, employee);
        editDialog.setVisible(true);

//

}

}