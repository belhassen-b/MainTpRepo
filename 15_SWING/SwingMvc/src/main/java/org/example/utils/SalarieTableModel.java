package org.example.utils;

import lombok.AllArgsConstructor;
import org.example.model.Salarie;

import javax.swing.table.AbstractTableModel;
import java.util.List;


@AllArgsConstructor
public class SalarieTableModel extends AbstractTableModel {

    private final String[] entetes = {"ID", "Nom", "Prenom", "Role", "Departement"};

    private final List<Salarie> data;
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Salarie salarie = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return salarie.getId();
            case 1:
                return salarie.getNom();
            case 2:
                return salarie.getPrenom();
            case 3:
                return salarie.getRole();
            case 4:
                return salarie.getDepartement();
            default:
                return null;
        }
    }
}
