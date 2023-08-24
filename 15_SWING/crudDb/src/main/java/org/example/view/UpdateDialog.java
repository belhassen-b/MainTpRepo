package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;
import javax.swing.*;
import java.awt.*;


public class UpdateDialog extends JDialog {


    private JTextField id;

    private JTextField txtName;

    private JTextField txtNumber;

    public void closeUpdateDialog() {
        setVisible(false);
    }

    public UpdateDialog(InsertDialog insertDialog) {
        super (insertDialog, "Update Contact", true);
        setSize(300, 200);
        setLocationRelativeTo(insertDialog);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        id = new JTextField();
        id.setBounds(80, 20, 80, 20);
        contentPanel.add(id);
        id.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(170, 20, 80, 20);
        contentPanel.add(btnSearch);

        txtName = new JTextField();
        txtName.setBounds(80, 50, 80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);

        txtNumber = new JTextField();
        txtNumber.setBounds(80, 80, 80, 20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(10, 20, 80, 20);
        contentPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 50, 80, 20);
        contentPanel.add(lblName);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(10, 80, 80, 20);
        contentPanel.add(lblNumber);

        JButton jButtonOK = new JButton("OK");
        JButton jButtonCancel = new JButton("Cancel");
        JButton btnUpdate = new JButton("Update");


        jButtonOK.addActionListener(e -> {
            if( id != null && !id.getText().isEmpty() && txtName != null && !txtName.getText().isEmpty() && txtNumber != null && !txtNumber.getText().isEmpty() ) {
                Contact contact = new Contact();
                contact.setId(Long.parseLong(id.getText()));
                contact.setName(txtName.getText());
                contact.setNumber(txtNumber.getText());
                ContactDao contactDao = new ContactDao();
                int nb = contactDao.updateContact(contact);
                if (nb == 1) {
                    JOptionPane.showMessageDialog(null, "Contact updated successfully");
                    closeUpdateDialog();
                    insertDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error while updating contact");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            }
        });

        jButtonCancel.addActionListener(e -> {
            closeUpdateDialog();
            insertDialog.setVisible(true);
        });

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelButton.add(jButtonOK);
        jPanelButton.add(jButtonCancel);
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        btnSearch.addActionListener(e -> {
            ContactDao contactDao = new ContactDao();
            Contact contact = contactDao.getContactById(Long.parseLong(id.getText()));
            txtName.setText(contact.getName());
            txtNumber.setText(contact.getNumber());
        });


        btnUpdate.addActionListener(e -> {
            Contact contact = new Contact();
            contact.setName(txtName.getText());
            contact.setNumber(txtNumber.getText());
            ContactDao contactDao = new ContactDao();
            int nb = contactDao.updateContact(contact);
            if (nb == 1) {
                JOptionPane.showMessageDialog(null, "Contact updated successfully");
                closeUpdateDialog();
                insertDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error while updating contact");
            }
        });

    }
}
