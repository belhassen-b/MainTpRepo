package org.example.utils;

import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DepartmentTableModel extends AbstractTableModel {

    private final List<Department> departmentsData;

    private final String[] columnNames = {"Id", "Nom Département"};

    public DepartmentTableModel(List<Department> departmentsData) {
        this.departmentsData = departmentsData;
    }

    @Override
    public int getRowCount() {
        return departmentsData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Department department = departmentsData.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> department.getId();
            case 1 -> department.getName();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
