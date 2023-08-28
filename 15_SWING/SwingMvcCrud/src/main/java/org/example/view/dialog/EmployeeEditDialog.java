package org.example.view.dialog;

import org.example.controller.EmployeeController;
import org.example.dao.DepartmentDAO;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.view.EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

public class EmployeeEditDialog extends JDialog {
       private Employee employee = new Employee();
    private JComboBox<String> txtDepartment;

    public EmployeeEditDialog(EmployeeManagement employeeManagement, Employee employee) {
        super(employeeManagement, "Modification d'un salarié", true);
        this.employee = employee;
        initComponents();
    }

    private void initComponents() {
        // initialisation
        JPanel contentPanel = new JPanel();
        setSize(500, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        //Champs de saisie
        // champs Prénom
        JLabel lblName = new JLabel("Nom");
        JTextField txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(80, 20, 300, 20);
        lblName.setBounds(10, 20, 80, 20);
        contentPanel.add(txtName);
        contentPanel.add(lblName);

        // champs Nom
        JLabel lblLastName = new JLabel("Prénom");
        JTextField txtLastName = new JTextField();
        txtLastName.setColumns(10);
        txtLastName.setBounds(80, 50, 300, 20);
        lblLastName.setBounds(10, 50, 80, 20);
        contentPanel.add(txtLastName);
        contentPanel.add(lblLastName);

        // champs Role
        Role[] roles = Role.values();
        ButtonGroup roleButtonGroup = new ButtonGroup();
        int x = 80;
        for (Role role : roles) {
            JRadioButton jRadioButton = new JRadioButton(String.valueOf(role));
            jRadioButton.setBounds(x, 80, 80, 20);
            contentPanel.add(jRadioButton);
            roleButtonGroup.add(jRadioButton);
            x += 100;
        }
        JLabel lblRole = new JLabel("Role");
        lblRole.setBounds(10, 80, 100, 20);
        contentPanel.add(lblRole);

        // champs Departement
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<String> departmentNames = departmentDAO.getAllDepartementNames();

        txtDepartment = new JComboBox<>();
        for (String departmentName : departmentNames) {
            txtDepartment.addItem(departmentName);
        }
        JLabel lblDepartment = new JLabel("Departement");
        txtDepartment.setBounds(80, 110, 300, 20);
        lblDepartment.setBounds(10, 110, 80, 20);
        contentPanel.add(txtDepartment);
        contentPanel.add(lblDepartment);

        // bouton Ajouter
        JButton btnSave = new JButton("Valider");
        btnSave.setBounds(80, 140, 80, 20);
        contentPanel.add(btnSave);
        // bouton Annuler
        JButton btnCancel = new JButton("Annuler");
        btnCancel.setBounds(200, 140, 80, 20);
        contentPanel.add(btnCancel);


        // Remplissage des champs
        txtName.setText(employee.getFirstName());
        txtLastName.setText(employee.getLastName());
        for (Enumeration<AbstractButton> buttons = roleButtonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.getText().equals(employee.getRole().toString())) {
                button.setSelected(true);
            }
        }
        txtDepartment.setSelectedItem(employee.getDepartments() );

        // Bouton Valider
        btnSave.addActionListener(e -> {
            EmployeeController employeeController = new EmployeeController();
            employee.setFirstName(txtName.getText());
            employee.setLastName(txtLastName.getText());
            for (Enumeration<AbstractButton> buttons = roleButtonGroup.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    employee.setRole(Role.valueOf(button.getText()));
                }
            }
            employee.setDepartments(String.valueOf(txtDepartment.getSelectedItem()));
            if( txtName != null && !txtName.getText().isEmpty() && txtLastName != null && !txtLastName.getText().isEmpty() && txtDepartment != null && !txtDepartment.getSelectedItem().toString().isEmpty() && roleButtonGroup.getSelection() != null ) {
                employeeController.updateEmployee(employee);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Merci de remplir tous les champs", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Bouton Annuler
        btnCancel.addActionListener(e -> dispose());
    }
}