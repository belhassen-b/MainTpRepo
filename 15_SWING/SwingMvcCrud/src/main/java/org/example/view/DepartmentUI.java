package org.example.view;

import org.example.controller.DepartmentController;
import org.example.model.Department;
import org.example.utils.DepartmentTableModel;

import javax.swing.*;

public class DepartmentUI extends JDialog {

    private final JTextField textFieldName;
    private DepartmentTableModel departmentTableModel;

    public DepartmentUI() {
        setTitle("Department");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Content pane
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        textFieldName = new JTextField();
        textFieldName.setBounds(80, 20, 150, 20);
        contentPane.add(textFieldName);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 20, 80, 20);
        contentPane.add(lblName);

        // Buttons
        JButton buttonOK = new JButton("OK");
        buttonOK.setBounds(80, 100, 80, 25);
        contentPane.add(buttonOK);

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(180, 100, 80, 25);
        contentPane.add(buttonCancel);

        // OK button action
        buttonOK.addActionListener(e -> {
            // add if statement to check if the text field is empty
            Department department = new Department();
            department.setName(textFieldName.getText());
            DepartmentController departmentController = new DepartmentController();
            departmentController.addDepartment(department);
            DepartmentManagement departmentManagement = new DepartmentManagement();
            departmentManagement.setVisible(true);
             dispose();
        });

        buttonCancel.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartmentUI dialog = new DepartmentUI();
            dialog.setVisible(true);
        });
    }
}
