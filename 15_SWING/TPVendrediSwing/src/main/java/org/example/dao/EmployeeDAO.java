package org.example.dao;

import org.example.model.Employee;
import org.example.utils.ConDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    private final Connection conDB;

    private PreparedStatement ps;

    private static final String ERROR_MESSAGE = "An exception occurred";

    public EmployeeDAO() {
        this.conDB = ConDB.getConnection();
    }

    public void addEmployee(Employee employee) {
        try {
            ps = conDB.prepareStatement("INSERT INTO employee"
        + "(name, gender, age, blood_group, contact_no, qualification, date_of_joining, address, emp_image)VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getBloodGroup());
            ps.setString(5, employee.getContactNo());
            ps.setString(6, employee.getQualification());
            ps.setDate(7, employee.getDateOfJoining());
            ps.setString(8, employee.getAddress());
            ps.setString(9, employee.getEmpImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

    public void deleteEmployee(long id) {
        try {
            ps = conDB.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            ps = conDB.prepareStatement("UPDATE  employee SET name = ? , gender = ? , age = ? , blood_group = ? , contact_no = ? , qualification = ? , date_of_joining = ? , address = ? , emp_image = ? WHERE employee_id = ?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getBloodGroup());
            ps.setString(5, employee.getContactNo());
            ps.setString(6, employee.getQualification());
            ps.setDate(7, employee.getDateOfJoining());
            ps.setString(8, employee.getAddress());
            ps.setString(9, employee.getEmpImage());
            ps.setLong(10, employee.getEmployeeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
    }

        public List<Employee> getAllEmployees() {
            ArrayList<Employee> employeeList = new ArrayList<>();
            try {
                ps = conDB.prepareStatement("SELECT * FROM employee");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    long employeeId = rs.getLong("employee_id");
                    String name = rs.getString("name");
                    String gender = rs.getString("gender");
                    int age = rs.getInt("age");
                    String bloodGroup = rs.getString("blood_group");
                    String contactNo = rs.getString("contact_no");
                    String qualification = rs.getString("qualification");
                    Date dateOfJoining = rs.getDate("date_of_joining");
                    String address = rs.getString("address");
                    String empImage = rs.getString("emp_image");

                    Employee employee = new Employee();
                    employee.setEmployeeId(employeeId);
                    employee.setName(name);
                    employee.setGender(gender);
                    employee.setAge(age);
                    employee.setBloodGroup(bloodGroup);
                    employee.setContactNo(contactNo);
                    employee.setQualification(qualification);
                    employee.setDateOfJoining(dateOfJoining);
                    employee.setAddress(address);
                    employee.setEmpImage(empImage);

                    employeeList.add(employee);

                }
            } catch (SQLException e) {
                Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
                logger.log(Level.SEVERE, ERROR_MESSAGE, e);
            }
            return employeeList;
        }

        public Employee getEmployeeById(Long id){
        Employee employee = null;
        try {
            ps = conDB.prepareStatement("SELECT * FROM employee WHERE employee_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String bloodGroup = rs.getString("blood_group");
                String contactNo = rs.getString("contact_no");
                String qualification = rs.getString("qualification");
                Date dateOfJoining = rs.getDate("date_of_joining");
                String address = rs.getString("address");
                String empImage = rs.getString("emp_image");




            }
        }
        catch (SQLException e) {
            Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        return employee;
        }

    public List<Employee> searchEmployee(String search) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            ps = conDB.prepareStatement(String.format("SELECT * FROM employee WHERE name LIKE '%%%s%%'", search));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                long employeeId = rs.getLong("employee_id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String bloodGroup = rs.getString("blood_group");
                String contactNo = rs.getString("contact_no");
                String qualification = rs.getString("qualification");
                Date dateOfJoining = rs.getDate("date_of_joining");
                String address = rs.getString("address");
                String empImage = rs.getString("emp_image");

                Employee employee = new Employee();
                employee.setEmployeeId(employeeId);
                employee.setName(name);
                employee.setGender(gender);
                employee.setAge(age);
                employee.setBloodGroup(bloodGroup);
                employee.setContactNo(contactNo);
                employee.setQualification(qualification);
                employee.setDateOfJoining(dateOfJoining);
                employee.setAddress(address);
                employee.setEmpImage(empImage);

                employeeList.add(employee);


            }
            System.out.println(search);
            System.out.println(employeeList);

        } catch (SQLException e) {
            Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
        }
        return employeeList;
        }
    }
