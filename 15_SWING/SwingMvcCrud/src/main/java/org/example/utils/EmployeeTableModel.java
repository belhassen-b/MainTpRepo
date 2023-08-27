package org.example.utils;

import org.example.model.Employee;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel  extends AbstractTableModel{

        private final List<Employee> data;
    private final String[] columnNames = {"Id", "First Name", "Last Name", "Role", "Department"};

    public EmployeeTableModel(List<Employee> employees) {
        this.data = employees;
    }

    @Override
        public int getRowCount() {
            return data.size();        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Employee employee = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> employee.getId();
                case 1 -> employee.getFirstName();
                case 2 -> employee.getLastName();
                case 3 -> employee.getRole();
                case 4 -> employee.getDepartments();
                default -> null;
            };
        }
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

    public void fireTableDataChanged() {
        fireTableChanged(new TableModelEvent(this)); // Assurez-vous que cette ligne est présente
    }


}