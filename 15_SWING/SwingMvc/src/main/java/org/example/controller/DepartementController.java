package org.example.controller;

import org.example.model.Departement;
import org.example.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartementController {
    private static final Logger logger = Logger.getLogger(DepartementController.class.getName());
    private final Connection connectionDB = ConnectionDB.getConnection();

    public int ajoutDepartement(Departement departement) {
        String errorMessage = "Erreur lors de l'ajout du département";
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement("INSERT INTO departement (nomDepartement) VALUES (?)");
            preparedStatement.setString(1, departement.getNomDepartement());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.log(Level.SEVERE, errorMessage, e);
            return 0;
        }
    }

    public int modifDepartement(Departement departement){
        String errorMessage = "Erreur lors de la modification du département";
        try {
            assert connectionDB != null;
            PreparedStatement preparedStatement = connectionDB.prepareStatement("UPDATE departement SET nomDepartement = ? WHERE id = ?");
            preparedStatement.setString(1, departement.getNomDepartement());
            preparedStatement.setLong(2, departement.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.log(Level.SEVERE, errorMessage, e);
            return 0;
        }
    }
    public void supprDepartement(Departement departement){
        String errorMessage = "Erreur lors de la suppression du département";
        try {
            assert connectionDB != null;
            PreparedStatement preparedStatement = connectionDB.prepareStatement("DELETE FROM departement WHERE id = ?");
            preparedStatement.setLong(1, departement.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.log(Level.SEVERE, errorMessage, e);

        }
    }
}