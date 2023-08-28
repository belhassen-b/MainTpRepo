package org.example.view;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectDialog extends JDialog {

    private JTable jTable1;

    public void closeSelectDialog() {
        setVisible(false);
    }


    public SelectDialog(CrudDialog crudDialog) {
        super(crudDialog, "Select Contact", true);
        setSize(400, 300);
        setLocationRelativeTo(crudDialog);
        initComponents();
        showContact();
    }

    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jTable1.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name", "Number"}));

        JButton btnOk = new JButton("OK");

        btnOk.setBounds(250, 270, 80, 20);
        getContentPane().add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSelectDialog();
            }
        });

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Id");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Number");
        } else {
            System.out.println("Pas de colonne à afficher");
        }

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
        pack();
    }

    private void showContact() {
        ArrayList<Contact> list = contactList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++) {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getNumber();
            model.addRow(row);
        }
    }

    private ArrayList<Contact> contactList() {
        ArrayList<Contact> contactList = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        String query = "SELECT * FROM contact";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contact contact;
            while (resultSet.next()) {
                contact = new Contact(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("number"));
                contactList.add(contact);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactList;
    }
}


