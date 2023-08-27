package org.example.utils;

import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.view.EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class EmployeeEditDialog extends JDialog {

    private Employee employee;

    private JTextField txtRole;
    private ButtonGroup roleButtonGroup;
    private JComboBox<String> txtDepartment;

    // Constructor
    public EmployeeEditDialog(Frame parent, Employee employee) {
        super(parent, "Edit Employee", true);
        this.employee = employee;
        initComponents();
    }

    public EmployeeEditDialog(EmployeeManagement employeeManagement, Employee employee) {
        super(employeeManagement, "Edit Employee", true);
        this.employee = employee;
        initComponents();
    }

    private void initComponents() {

        JPanel contentPanel = new JPanel();
        setSize(500, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JTextField txtName = new JTextField();
        txtName.setBounds(80, 20, 300, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 20, 80, 20);
        contentPanel.add(lblName);

        JTextField txtLastName = new JTextField();
        txtLastName.setBounds(80, 50, 300, 20);
        contentPanel.add(txtLastName);
        txtLastName.setColumns(10);
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(10, 50, 80, 20);
        contentPanel.add(lblLastName);

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
        lblRole.setBounds(10, 80, 80, 20);
        contentPanel.add(lblRole);


        txtDepartment = new JComboBox<>(new String[]{"IT", "HR", "Finance"});
        txtDepartment.setBounds(80, 110, 300, 20);
        contentPanel.add(txtDepartment);
        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(10, 110, 80, 20);
        contentPanel.add(lblDepartment);


//        JTextField txtRole = new JTextField();
//        txtRole.setBounds(80, 80, 300, 20);
//        contentPanel.add(txtRole);
//        txtRole.setColumns(10);
//        JLabel lblRole = new JLabel("Role");
//        lblRole.setBounds(10, 80, 80, 20);
//        contentPanel.add(lblRole);
//
//        JTextField txtDepartment = new JTextField();
//        txtDepartment.setBounds(80, 110, 300, 20);
//        contentPanel.add(txtDepartment);
//        txtDepartment.setColumns(10);
//        JLabel lblDepartment = new JLabel("Department");
//        lblDepartment.setBounds(10, 110, 80, 20);
//        contentPanel.add(lblDepartment);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(80, 140, 80, 20);
        contentPanel.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 140, 80, 20);
        contentPanel.add(btnCancel);

        txtName.setText(employee.getFirstName());
        txtLastName.setText(employee.getLastName());
for (Enumeration<AbstractButton> buttons = roleButtonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.getText().equals(employee.getRole().toString())) {
                button.setSelected(true);
            }
        }
        txtDepartment.setSelectedItem(employee.getDepartments());

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

            employeeController.updateEmployee(employee);


            dispose();
        });

        btnCancel.addActionListener(e -> dispose());
    }
}