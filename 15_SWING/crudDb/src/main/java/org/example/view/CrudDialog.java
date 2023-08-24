package org.example.view;

import javax.swing.*;
import java.awt.*;


public class CrudDialog extends JDialog {

    public void closeCrudDialog() {
        setVisible(false);

    }

    public CrudDialog(InsertDialog insertDialog ) {
        super(insertDialog, "CRUD Options", true);
        setSize(300, 200);
        setLocationRelativeTo(insertDialog);
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        contentPanel.add(buttonPanel, BorderLayout.CENTER);


        JButton btnInsert = new JButton("Insert");
        buttonPanel.add(btnInsert);


        JButton btnUpdate = new JButton("Update");
        buttonPanel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        buttonPanel.add(btnDelete);


        JButton btnSelect = new JButton("Select");
        contentPanel.add(btnSelect, BorderLayout.SOUTH);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);


        btnInsert.addActionListener(e -> {
               InsertDialog insertDialog1 = new InsertDialog();
               insertDialog1.setVisible(true);
               setVisible(false);


           });

              btnUpdate.addActionListener(e -> {
                   UpdateDialog updateDialog = new UpdateDialog(insertDialog);
                   updateDialog.setVisible(true);
              });

                 btnDelete.addActionListener(e -> {
                      DeleteDialog deleteDialog = new DeleteDialog(insertDialog);
                      deleteDialog.setVisible(true);

                  });

        btnSelect.addActionListener(e -> {
            SelectDialog selectDialog = new SelectDialog(CrudDialog.this);
            selectDialog.setVisible(true);
        });

        JButton jButtonCancel = new JButton("Cancel");
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(e -> closeCrudDialog());
    }
}