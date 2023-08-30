package org.example.utils;

import lombok.Data;
import org.example.model.Employee;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;



@Data
public class BottomTableModel  extends AbstractTableModel implements TableModel {
    private final List<Employee> data;

    private final String[] columnNames = {"EmployeeId", "Name", "Gender", "Age", "BloodGroup", "ContactNo", "Qualification", "DOJ", "Address", "EmpImage"};
    public BottomTableModel(List<Employee> employees) {
        this.data = employees;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> employee.getEmployeeId();
            case 1 -> employee.getName();
            case 2 -> employee.getGender();
            case 3 -> employee.getAge();
            case 4 -> employee.getBloodGroup();
            case 5 -> employee.getContactNo();
            case 6 -> employee.getQualification();
            case 7 -> employee.getDateOfJoining();
            case 8 -> employee.getAddress();
            case 9 -> employee.getEmpImage();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    public void addRow(Object[] objects) {

        Employee employee = new Employee();
        employee.setEmployeeId((Long) objects[0]);
        employee.setName((String) objects[1]);
        employee.setGender((String) objects[2]);
        employee.setAge((Integer) objects[3]);
        employee.setBloodGroup((String) objects[4]);
        employee.setContactNo((String) objects[5]);
        employee.setQualification((String) objects[6]);
        employee.setDateOfJoining((java.sql.Date) objects[7]);
        employee.setAddress((String) objects[8]);
        employee.setEmpImage((String) objects[9]);
        data.add(employee);

        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }

}
