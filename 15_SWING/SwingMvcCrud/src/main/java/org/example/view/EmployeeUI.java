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
import java.util.Objects;

public class EmployeeUI extends JDialog {

    private final JTextField txtName, txtLastName;
    private final JComboBox<String> txtDepartment;

    public static void main(String[] args) {
        EmployeeUI dialog = new EmployeeUI();
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public EmployeeUI() {
        // initialisation
        JTable table = new JTable();
        JPanel contentPanel = new JPanel();

        // initialisation
        txtName = new JTextField();
        txtLastName = new JTextField();
        txtDepartment = new JComboBox<>();

        // model de la table basé sur la liste des employés
        table.setModel(new EmployeeTableModel(new ArrayList<>()));
        table.setBounds(10, 10, 500, 300);
        JScrollPane jScrollPane = new JScrollPane(table);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);

        setTitle("Ajout d'un salarié");
        setSize(500, 200);
        setLocationRelativeTo(null);

        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);



        //Champs de saisie
        // champs Prénom
        JLabel lblName = new JLabel("Prénom");
        lblName.setBounds(10, 20, 80, 20);
        txtName.setBounds(80, 20, 300, 20);
        txtName.setColumns(10);
        contentPanel.add(lblName);
        contentPanel.add(txtName);

        // champs Nom
        JLabel lblLastName = new JLabel("Nom");
        lblLastName.setBounds(10, 50, 80, 20);
        txtLastName.setBounds(80, 50, 300, 20);
        txtLastName.setColumns(10);
        contentPanel.add(txtLastName);
        contentPanel.add(lblLastName);

        // champs Role depuis l'enum Role
        Role[] roles = Role.values();
        ButtonGroup btnGroup = new ButtonGroup();
        JLabel lblRole = new JLabel("Role");
        lblRole.setBounds(10, 80, 100, 20);
        contentPanel.add(lblRole);

        int x = 80;
        for (Role role : roles) {
            JRadioButton jRadioButton = new JRadioButton(String.valueOf(role));
            jRadioButton.setBounds(x, 80, 100, 20);
            contentPanel.add(jRadioButton);
            btnGroup.add(jRadioButton);
            x += 100;
        }

        // champs Département depuis la liste des départements
        DepartmentController departmentController = new DepartmentController();
        List<String> departmentNames = departmentController.getAllDepartementNames();



        for (String departmentName : departmentNames) {
            txtDepartment.addItem(departmentName);
        }
        JLabel lblDepartment = new JLabel("Departement");
        lblDepartment.setBounds(10, 110, 80, 20);
        txtDepartment.setBounds(80, 110, 300, 20);
        contentPanel.add(txtDepartment, lblDepartment);

        // bouton Ajouter
        JButton addButton = new JButton("Ajouter");
        addButton.setBounds(170, 140, 80, 20);
        contentPanel.add(addButton);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelButton.add(addButton);
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        // action du bouton Ajouter
        addButton.addActionListener(e -> {
            EmployeeManagement employeeManagement = new EmployeeManagement();
            employeeManagement.setVisible(false);

            if (!txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !Objects.requireNonNull(txtDepartment.getSelectedItem()).toString().isEmpty() && btnGroup.getSelection() != null) {
                Employee employee = new Employee();
                employee.setFirstName(txtName.getText());
                employee.setLastName(txtLastName.getText());
                employee.setDepartments(Objects.requireNonNull(txtDepartment.getSelectedItem()).toString());
                for (Enumeration<AbstractButton> buttons = btnGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        employee.setRole(Role.valueOf(button.getText()));
                    }
                }
                EmployeeController employeeController = new EmployeeController();
                employeeController.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "Salarié ajouté avec succès");
                setVisible(false);
                new EmployeeManagement().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Merci de remplir tous les champs", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
