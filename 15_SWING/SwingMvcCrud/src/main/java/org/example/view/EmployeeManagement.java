package org.example.view;

import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.view.dialog.EmployeeEditDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class EmployeeManagement extends JDialog {

    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagement dialog = new EmployeeManagement();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }

    public EmployeeManagement() {
        super();
        setTitle("Gestion des salariés");
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        showEmployees(table);

    }

    private void initComponents() {
        // initialisation
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        JPanel footerPanel = new JPanel();

        // Ajout des composants
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Prénom", "Nom", "Role", "Departement"}));
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Prénom");
            table.getColumnModel().getColumn(2).setHeaderValue("Nom");
            table.getColumnModel().getColumn(3).setHeaderValue("Role");
            table.getColumnModel().getColumn(4).setHeaderValue("Departement");
        }

        // Ajout des composants au footerPanel
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        getContentPane().add(scrollPane);

        // Bouton Ajouter
        JButton btnAdd = new JButton("Ajouter");
        btnAdd.setPreferredSize(new Dimension(120, 20));
        btnAdd.addActionListener(e -> {
            EmployeeUI insertDialog = new EmployeeUI();
            insertDialog.setVisible(true);
            setVisible(false);

        });


        // Bouton Editer
        JButton btnEdit = new JButton("Editer");
        btnEdit.setPreferredSize(new Dimension(120, 20));
        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Merci de selectionner 1 salarié", "Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'envoi des données", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Bouton Supprimer
        JButton btnDelete = new JButton("Supprimer");
        btnDelete.setPreferredSize(new Dimension(120, 20));
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Merci de selectionner 1 salarié", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce salarié? ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    EmployeeController employeeController = new EmployeeController();
                    employeeController.deleteEmployee((long) id);
                    JOptionPane.showMessageDialog(null, "Salarié a été supprimé ", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    employeeManagement.setVisible(true);
                }
            }
        });

        // Bouton Departement
        JButton btnDepartment = new JButton("Departement");
        btnDepartment.setPreferredSize(new Dimension(120, 20));
        btnDepartment.addActionListener(e -> {
            DepartmentManagement departmentDialog = new DepartmentManagement();
            departmentDialog.setVisible(true);
            setVisible(false);

        });

        // Ajout des boutons au footerPanela
        footerPanel.add(btnAdd);
        footerPanel.add(btnEdit);
        footerPanel.add(btnDelete);
        footerPanel.add(btnDepartment);

    }

    private void openEditDialog(Employee employee) {
        // Create and show the edit dialog, passing the employee data
        EmployeeEditDialog editDialog = new EmployeeEditDialog(this, employee);
        editDialog.setVisible(true);
    }
        public static void showEmployees(JTable table) {
            EmployeeController employeeController = new EmployeeController();
            List<Employee> employees = employeeController.  getAllEmployees();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Employee employee : employees) {
                Object[] rowData = {employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getRole(), employee.getDepartments()};
                model.addRow(rowData);
            }

        }

    }


