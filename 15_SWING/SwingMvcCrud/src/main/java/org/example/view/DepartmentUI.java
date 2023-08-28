package org.example.view;

import org.example.controller.DepartmentController;
import org.example.model.Department;
import org.example.utils.DepartmentTableModel;

import javax.swing.*;
import java.awt.*;





public class DepartmentUI extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartmentUI dialog = new DepartmentUI();
            dialog.setVisible(true);
        });
    }
    private final JTextField textFieldName;
    private DepartmentTableModel departmentTableModel;

    public DepartmentUI() {
        // Initialisation
        JTable table = new JTable();
        JPanel contentPanel = new JPanel();

        //Initialisation
        textFieldName = new JTextField();

        // Model de la table basé sur la liste des départements
        table.setModel(new DepartmentTableModel(new DepartmentController().getAllDepartments()));
        table.setBounds(10, 10, 400, 300);
        JScrollPane jScrollPane = new JScrollPane(table);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);

        setTitle("Ajout d'un département");
        setSize(500, 200);
        setLocationRelativeTo(null);

        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //Champs de saisie
        JLabel lblName = new JLabel("Nom");
        lblName.setBounds(10, 20, 80, 20);
        textFieldName.setBounds(80, 20, 300, 20);
        textFieldName.setColumns(10);
        contentPanel.add(textFieldName);
        contentPanel.add(lblName);

        // Bouton Ok pour la validation
        JButton buttonOK = new JButton("OK");
        buttonOK.setBounds(80, 100, 80, 25);
          contentPanel.add(buttonOK);

        // Bouton Annuler pour l'annulation
        JButton buttonCancel = new JButton("Annuler");
        buttonCancel.setBounds(200, 100, 80, 25);
        contentPanel.add(buttonCancel);


        // Bouton OK
        buttonOK.addActionListener(e -> {
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


}
