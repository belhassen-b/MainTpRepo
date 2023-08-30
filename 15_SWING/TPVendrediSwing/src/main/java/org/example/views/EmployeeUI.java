package org.example.views;

import org.example.controller.EmployeeController;
import org.example.dao.EmployeeDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.toedter.calendar.JDateChooser;
import org.example.model.BloodGroup;
import org.example.model.Employee;
import org.example.model.Qualification;
import org.example.utils.BottomTableModel;

public class EmployeeUI extends JFrame {

    private final JFileChooser fileChooser = new JFileChooser();

    private BloodGroup bloodGroup;

    private EmployeeDAO employeeDAO;

    private EmployeeController employeeController = new EmployeeController();


    private BottomTableModel model;
    private JButton newButton;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton printButton;
    private JTable table;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtContactNo;
    private JTextField txtAddress;
    private JTextField txtEmpImage;
    private JComboBox<BloodGroup> txtBloodGroup;
    private JComboBox<Qualification> txtQualification;
    private JDateChooser dateChooser;
    private JRadioButton jRadioButton;
    private JRadioButton jRadioButton1;
    private ButtonGroup btnGroup;


    public EmployeeUI() {
        super();

        model = new BottomTableModel(new ArrayList<>());
        employeeDAO = new EmployeeDAO();

        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024, 900);
        setLocationRelativeTo(null);


        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();


        JPanel contentPanel = new JPanel(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        JPanel headerPanel = new JPanel(new BorderLayout(10, 10));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);


        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(780, 350));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBounds(200, 0, 700, 40);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBounds(0, 0, 1024, 350);


        setVisible(true);


        JLabel lblId = new JLabel("Employee Id");
        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setBackground(Color.LIGHT_GRAY);
        lblId.setBounds(20, 20, 80, 20);
        txtId.setBounds(110, 20, 150, 20);
        txtId.setColumns(10);
        headerPanel.add(lblId);
        headerPanel.add(txtId);

        JLabel lblName = new JLabel("Name");
        txtName = new JTextField();
        lblName.setBounds(20, 45, 80, 20);
        txtName.setBounds(110, 45, 150, 20);
        txtName.setColumns(10);
        headerPanel.add(lblName);
        headerPanel.add(txtName);

        btnGroup = new ButtonGroup();
        jRadioButton = new JRadioButton("Male");
        jRadioButton1 = new JRadioButton("Female");
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(20, 70, 150, 20);
        jRadioButton.setBounds(110, 70, 70, 20);
        jRadioButton1.setBounds(190, 70, 70, 20);
        headerPanel.add(lblGender);
        btnGroup.add(jRadioButton);
        btnGroup.add(jRadioButton1);
        headerPanel.add(jRadioButton);
        headerPanel.add(jRadioButton1);

        JLabel lblAge = new JLabel("Age");
        txtAge = new JTextField(2);
        lblAge.setBounds(20, 95, 80, 20);
        txtAge.setBounds(110, 95, 150, 20);
        txtAge.setColumns(10);
        txtAge.addKeyListener(new KeyAdapter() {
                              public void keyPressed(KeyEvent ke) {
                                  String value = txtAge.getText();
                                  int l = value.length();
                                  if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                                      txtAge.setEditable(true);
                                      lblAge.setText("Age");
                                  } else {
                                      txtAge.setEditable(false);
                                      lblAge.setText("AGE !!!");
                              }
                            }
                            });


        headerPanel.add(lblAge);
        headerPanel.add(txtAge);


        JLabel lblContactNo = new JLabel("Contact No");
        txtContactNo = new JTextField();
        lblContactNo.setBounds(20, 120, 80, 20);
        txtContactNo.setBounds(110, 120, 150, 20);
        txtContactNo.setColumns(10);
        headerPanel.add(lblContactNo);
        headerPanel.add(txtContactNo);

        BloodGroup[] bloodGroups = BloodGroup.values();
        JComboBox<BloodGroup> txtBloodGroup = new JComboBox<>(bloodGroups);
        txtBloodGroup.setBounds(110, 150, 150, 20);
        headerPanel.add(txtBloodGroup);

        JLabel lblBloodGroup = new JLabel("Blood Group");
        lblBloodGroup.setBounds(20, 150, 80, 20);
        headerPanel.add(lblBloodGroup);

        JLabel lblQualification = new JLabel("Qualification");
        lblQualification.setBounds(20, 185, 80, 20);
        lblQualification.setPreferredSize(new Dimension(150, 20));
        headerPanel.add(lblQualification);

        Qualification[] qualifications = Qualification.values();
        JComboBox<Qualification> txtQualification = new JComboBox<>(qualifications);
        txtQualification.setBounds(110, 185, 150, 20);
        headerPanel.add(txtQualification);

        JLabel lblDateOfJoining = new JLabel("Date Of Joining");
        JDateChooser dateChooser = new JDateChooser();
        lblDateOfJoining.setBounds(20, 215, 80, 20);
        dateChooser.setBounds(110, 215, 150, 20);
        headerPanel.add(lblDateOfJoining);
        headerPanel.add(dateChooser);

        JLabel lblAddress = new JLabel("Address:");
        txtAddress = new JTextField();
        lblAddress.setBounds(290, 20, 80, 20);
        txtAddress.setBounds(340, 20, 300, 200);
        txtAddress.setColumns(10);
        headerPanel.add(lblAddress);
        headerPanel.add(txtAddress);

        JButton btnUploadImage = new JButton("Upload Image");
        btnUploadImage.setBounds(340, 230, 300, 20);
        headerPanel.add(btnUploadImage);

        txtEmpImage = new JTextField();
        JLabel lblEmpImage = new JLabel("Image Path");
        lblEmpImage.setBounds(260, 265, 80, 20);
        txtEmpImage.setBounds(340, 265, 300, 20);
        txtEmpImage.setColumns(10);
        headerPanel.add(lblEmpImage);
        headerPanel.add(txtEmpImage);


        JLabel lblImagePreview = new JLabel();
        lblImagePreview.setPreferredSize(new Dimension(300, 250));
        lblImagePreview.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        lblImagePreview.setHorizontalAlignment(SwingConstants.RIGHT);
        lblImagePreview.setVerticalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblImagePreview);

        // Mise à jour
        btnUploadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    txtEmpImage.setText(imagePath);
                    imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 250, Image.SCALE_SMOOTH));
                    lblImagePreview.setIcon(imageIcon);
                }
            }
        });

        /* CenterPanel */

        JLabel lblSearch = new JLabel("Search:");
        JTextField txtSearch = new JTextField(15);

        centerPanel.add(lblSearch);
        centerPanel.add(txtSearch);

        ImageIcon newIcon = new ImageIcon("src/main/resources/images/new.png");
        newIcon.setImage(newIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        newButton = new JButton("New", newIcon);
        centerPanel.add(newButton);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                txtEmpImage.setText("");
                lblImagePreview.setIcon(null);
                txtSearch.setText("");
                deleteButton.setEnabled(false);
                updateButton.setEnabled(false);
                printButton.setEnabled(false);
                clearButton.setEnabled(false);
                saveButton.setEnabled(true);

            }
        });

        ImageIcon saveIcon = new ImageIcon("src/main/resources/images/floppy.png");
        saveIcon.setImage(saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        saveButton = new JButton("Save", saveIcon);
        centerPanel.add(saveButton);


        // Ajout d'un employé
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setName(txtName.getText());
                employee.setAge(Integer.parseInt(txtAge.getText()));
                employee.setContactNo(txtContactNo.getText());
                employee.setAddress(txtAddress.getText());
                for (Enumeration<AbstractButton> buttons = btnGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        employee.setGender(button.getText());
                    }
                }
                employee.setBloodGroup(String.valueOf((BloodGroup) txtBloodGroup.getSelectedItem()));
                employee.setQualification(String.valueOf((Qualification) txtQualification.getSelectedItem()));
                employee.setDateOfJoining(new Date(dateChooser.getDate().getTime()));
                employee.setEmpImage(txtEmpImage.getText());
                employeeController.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "L'employé a bien été ajouté !", "Success", JOptionPane.INFORMATION_MESSAGE);
                showEmployees(table);
            }

        });

        ImageIcon updateIcon = new ImageIcon("src/main/resources/images/pen.png");
        updateIcon.setImage(updateIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        updateButton = new JButton("Update", updateIcon);
        centerPanel.add(updateButton);

        // Mise à jour d'un employé
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setEmployeeId(Long.parseLong(txtId.getText()));
                employee.setName(txtName.getText());
                employee.setAge(Integer.parseInt(txtAge.getText()));
                employee.setContactNo(txtContactNo.getText());
                employee.setAddress(txtAddress.getText());
                for (Enumeration<AbstractButton> buttons = btnGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        employee.setGender(button.getText());
                    }
                }
                employee.setBloodGroup(String.valueOf((BloodGroup) txtBloodGroup.getSelectedItem()));
                employee.setQualification(String.valueOf((Qualification) txtQualification.getSelectedItem()));
                employee.setDateOfJoining(new Date(dateChooser.getDate().getTime()));
                employee.setEmpImage(txtEmpImage.getText());
                employeeDAO.updateEmployee(employee);
                JOptionPane.showMessageDialog(null, "L'employé a bien été mis à jour !", "Success", JOptionPane.INFORMATION_MESSAGE);
                showEmployees(table);
            }
        });


        ImageIcon deleteIcon = new ImageIcon("src/main/resources/images/delete.png");
        deleteIcon.setImage(deleteIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        deleteButton = new JButton("Delete", deleteIcon);
        centerPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setEmployeeId(Long.parseLong(txtId.getText()));
                employeeDAO.deleteEmployee(employee.getEmployeeId());
                JOptionPane.showMessageDialog(null, "L'employé a bien été supprimé !", "Success", JOptionPane.INFORMATION_MESSAGE);
                showEmployees(table);
            }
        });

        ImageIcon clearIcon = new ImageIcon("src/main/resources/images/clear.png");
        clearIcon.setImage(clearIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        clearButton = new JButton("Clear", clearIcon);
        centerPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                txtEmpImage.setText("");
                lblImagePreview.setIcon(null);
                txtSearch.setText("");
                deleteButton.setEnabled(false);
                updateButton.setEnabled(false);
                printButton.setEnabled(false);
                clearButton.setEnabled(false);
                saveButton.setEnabled(true);
            }
        });

        ImageIcon printIcon = new ImageIcon("src/main/resources/images/printer.png");
        printIcon.setImage(printIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        printButton = new JButton("Print", printIcon);
        centerPanel.add(printButton);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        table.setModel(model);
        table.setPreferredSize(new Dimension(1024, 400));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    txtId.setText(table.getValueAt(selectedRow, 0).toString());
                    txtName.setText(table.getValueAt(selectedRow, 1).toString());
                    if (jRadioButton.getText().equals(table.getValueAt(selectedRow, 2).toString())) {
                        jRadioButton.setSelected(true);
                    } else {
                        jRadioButton1.setSelected(true);
                    }
                    txtAge.setText(table.getValueAt(selectedRow, 3).toString());
                    txtContactNo.setText(table.getValueAt(selectedRow, 5).toString());
                    for (int i = 0; i < txtBloodGroup.getItemCount(); i++) {
                        if (txtBloodGroup.getItemAt(i).toString().equals(table.getValueAt(selectedRow, 4).toString())) {
                            txtBloodGroup.setSelectedIndex(i);
                        }
                    }
                    for (int i = 0; i < txtQualification.getItemCount(); i++) {
                        if (txtQualification.getItemAt(i).toString().equals(table.getValueAt(selectedRow, 6).toString())) {
                            txtQualification.setSelectedIndex(i);
                        }
                    }

                    dateChooser.setDate((Date) table.getValueAt(selectedRow, 7));
                    txtAddress.setText(table.getValueAt(selectedRow, 8).toString());
                    txtEmpImage.setText(table.getValueAt(selectedRow, 9).toString());
                    ImageIcon imageIcon = new ImageIcon(txtEmpImage.getText());
                    imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 250, Image.SCALE_SMOOTH));

                    lblImagePreview.setIcon(imageIcon);
                    deleteButton.setEnabled(true);
                    updateButton.setEnabled(true);
                    printButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    saveButton.setEnabled(false);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane(table);
        footerPanel.add(jScrollPane, BorderLayout.CENTER);
        showEmployees(table);


 txtSearch.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String search = txtSearch.getText();
                List<Employee> employees = employeeController.searchEmployee(search);
                model.getData().clear();
                for (Employee employee : employees) {
                    model.addRow(new Object[]{employee.getEmployeeId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getBloodGroup(), employee.getContactNo(), employee.getQualification(), employee.getDateOfJoining(), employee.getAddress(), employee.getEmpImage()});
                }
                model.fireTableDataChanged();
            }

        }
    }
    );

    }


    /* ----------------------------------------------------------   */

    public void showEmployees(JTable table) {
        EmployeeController employeeController = new EmployeeController();
        List<Employee> employees = employeeController.getAllEmployees();
        BottomTableModel model = (BottomTableModel) table.getModel();
        model.getData().clear();

        for (Employee employee : employees) {
            model.addRow(new Object[]{employee.getEmployeeId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getBloodGroup(), employee.getContactNo(), employee.getQualification(), employee.getDateOfJoining(), employee.getAddress(), employee.getEmpImage()});
        }

        model.fireTableDataChanged();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeUI();
        });
    }
}





