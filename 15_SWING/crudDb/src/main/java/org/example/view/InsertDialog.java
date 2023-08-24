package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {

    private JPanel contentPanel;

    private JButton crudButton;

    private JTextField txtName;
    private JTextField txtNumber;

    public static void main(String[] args) {
        InsertDialog dialog = new InsertDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public InsertDialog() {
        contentPanel = new JPanel();
        setTitle("Insertion Contact");
        setSize(300, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);



        txtNumber = new JTextField();
        txtNumber.setBounds(80, 50, 80, 20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(80, 20, 80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 20, 80, 20);
        contentPanel.add(lblName);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(10, 50, 80, 20);
        contentPanel.add(lblNumber);

        crudButton = new JButton("CRUD");
        crudButton.setBounds(170, 20, 80, 20);
        contentPanel.add(crudButton);


        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelButton.add(crudButton);
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);


        crudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrudDialog crudDialog = new CrudDialog(InsertDialog.this);
                crudDialog.setVisible(true);
                dispose();
            }
        });

        JButton jButtonOK = new JButton("OK");
        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Contact contact = new Contact();
                contact.setName(txtName.getText());
                contact.setNumber(txtNumber.getText());
                ContactDao contactDao = new ContactDao();
                int count = contactDao.addContact(contact);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Contact added successfully");
                    setVisible(false);
                    CrudDialog crudDialog = new CrudDialog(InsertDialog.this);
                    crudDialog.setVisible(true);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        jPanelButton.add(jButtonOK);


        JButton jButtonCancel = new JButton("Cancel");
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}