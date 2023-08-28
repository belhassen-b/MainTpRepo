package org.example.view;

import org.example.utils.ListeSalaries;
import org.example.utils.dialog.InsertionDialog;
import org.example.utils.dialog.MiseAJourDialog;
import org.example.utils.dialog.SuppressionDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainManagement extends JDialog {
    private JTable table;

    private JPanel jPanel;
    private ListeSalaries listeSalaries;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainManagement dialog = new MainManagement();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }

    public MainManagement() {
        super();
        setTitle("Gestion des salariés");
        setSize(1024, 860);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Prenom", "Nom", "Role", "Departement"}));
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Prenom");
            table.getColumnModel().getColumn(2).setHeaderValue("Nom");
            table.getColumnModel().getColumn(3).setHeaderValue("Role");
            table.getColumnModel().getColumn(4).setHeaderValue("Departement");
        }
        JButton btnAjout = new JButton("Ajouter");

        btnAjout.setBounds(10, 10, 80, 20);
        btnAjout.setBackground(Color.GREEN);
        btnAjout.setForeground(Color.BLACK);
        btnAjout.setPreferredSize(new Dimension(120, 20));
        getContentPane().add(btnAjout);

        btnAjout.addActionListener(e -> {
                    SalarieUI salarieUI = new SalarieUI();
                    salarieUI.setVisible(true);
                    salarieUI.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                }
        );

    }
}

