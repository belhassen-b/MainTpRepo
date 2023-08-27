package org.example.view;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.utils.EmployeeTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class EmployeeUI extends JDialog {

    private  JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtRole;
    private ButtonGroup roleButtonGroup;
    private JComboBox<String> txtDepartment;

    public EmployeeUI(Employee employee, EmployeeManagement employeeManagement) {

    }


    public static void main(String[] args) {
        EmployeeUI dialog = new EmployeeUI();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public EmployeeUI() {

        JTable table = new JTable();
        table.setModel(new EmployeeTableModel(new ArrayList<>()));
        table.setBounds(10, 10, 400, 300);
        JScrollPane jScrollPane = new JScrollPane(table);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);


        JPanel contentPanel = new JPanel();
        setTitle("Add an employee");
        setSize(500, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(80, 20, 300, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 20, 80, 20);
        contentPanel.add(lblName);

        txtLastName = new JTextField();
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

        DepartmentController departmentController = new DepartmentController();
        List<String> departmentNames = departmentController.getAllDepartementNames();

        txtDepartment = new JComboBox<>();

        for (String departmentName : departmentNames) {
            txtDepartment.addItem(departmentName);
        }
        txtDepartment.setBounds(80, 110, 300, 20);
        contentPanel.add(txtDepartment);
        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(10, 110, 80, 20);
        contentPanel.add(lblDepartment);


        JButton addButton = new JButton("Add");
        addButton.setBounds(170, 140, 80, 20);
        contentPanel.add(addButton);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelButton.add(addButton);
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);


        addButton.addActionListener(e -> {
            EmployeeManagement employeeManagement = new EmployeeManagement();
            employeeManagement.setVisible(false);

            if (!txtName.getText().isEmpty() && !txtLastName.getText().isEmpty()) {
                Employee employee = new Employee();
                employee.setFirstName(txtName.getText());
                employee.setLastName(txtLastName.getText());
                employee.setDepartments(txtDepartment.getSelectedItem().toString());
                for (Enumeration<AbstractButton> buttons = roleButtonGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        employee.setRole(Role.valueOf(button.getText()));
                    }
                }
                EmployeeController employeeController = new EmployeeController();
                employeeController.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "Employee added successfully");
//                employeeController.getAllEmployees();
                setVisible(false);
                new EmployeeManagement().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            }



        });
    }

}
