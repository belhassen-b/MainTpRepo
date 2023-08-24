package org.example.view;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {

    private InsertDialog insertDialog;

    private JPanel contentPanel;




    private JTextField id;


    private JButton btnDelete;

    private JButton btnOk;

    private JButton btnCancel;

    public void closeDeleteDialog() {
        setVisible(false);
    }


    public DeleteDialog(InsertDialog insertDialog){
        super(insertDialog, "Delete Contact", true);
        setSize(300, 200);
        setLocationRelativeTo(insertDialog);

        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        id = new JTextField();
        id.setBounds(80, 20, 80, 20);
        contentPanel.add(id);
        id.setColumns(10);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(10, 20, 80, 20);
        contentPanel.add(lblId);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(170, 20, 80, 20);
        contentPanel.add(btnDelete);

        JButton btnOk = new JButton("OK");
        btnOk.setBounds(170, 20, 80, 20);
        contentPanel.add(btnOk);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(170, 20, 80, 20);
        contentPanel.add(btnCancel);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanelButton.add(btnOk);
        jPanelButton.add(btnCancel);
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        this.insertDialog = insertDialog;

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactDao contactDao = new ContactDao();
                Contact contact = new Contact();
                contact.setId(Long.parseLong(id.getText()));
                int nb = contactDao.deleteContact(contact);
                if (nb == 1) {
                    JOptionPane.showMessageDialog(null, "Contact deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error while deleting contact");
                }
                closeDeleteDialog();
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDeleteDialog();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDeleteDialog();
            }
        });










    }

}
