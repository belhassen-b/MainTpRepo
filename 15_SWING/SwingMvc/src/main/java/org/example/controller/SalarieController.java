package org.example.controller;

import org.example.model.Role;
import org.example.model.Salarie;
import org.example.utils.ConnectionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalarieController {

    // pour la connexion à la base de données
    private final Connection connectionDB;

    public SalarieController() {
        connectionDB = ConnectionDB.getConnection();
    }

    // Pour ajouter un salarié
    public int ajoutSalarie(Salarie salarie) {
        String messageErreur = "Erreur lors de l'ajout du salarié";
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement("INSERT INTO salarie (nom, prenom, role, departement) VALUES (?,?,?, ?)");
            preparedStatement.setString(1, salarie.getNom());
            preparedStatement.setString(2, salarie.getPrenom());
            preparedStatement.setString(3, salarie.getRole().toString());
            preparedStatement.setString(4, salarie.getDepartement());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salarie ajouté avec succès");
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SalarieController.class.getName());
            logger.log(Level.SEVERE, messageErreur, e);
        }
        return 0;
    }

    // Pour modifier un salarié
    public int modifSalarie(Salarie salarie){
        String messageErreur = "Erreur lors de la modification du salarié";
        try {
            assert connectionDB != null;
            PreparedStatement preparedStatement = connectionDB.prepareStatement("UPDATE salarie SET nom = ?, prenom = ?, role = ?, departement = ? WHERE id = ?");
            preparedStatement.setString(1, salarie.getNom());
            preparedStatement.setString(2, salarie.getPrenom());
            preparedStatement.setString(3, salarie.getRole().toString());
            preparedStatement.setString(4, salarie.getDepartement());
            preparedStatement.setLong(5, salarie.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salarie modifié avec succès");
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SalarieController.class.getName());
            logger.log(Level.SEVERE, messageErreur, e);
        }
        return 0;
    }

    // Pour supprimer un salarié
    public void supprSalarie(Salarie salarie){
        String messageErreur = "Erreur lors de la suppression du salarié";
        try {
            assert connectionDB != null;
            PreparedStatement preparedStatement = connectionDB.prepareStatement("DELETE FROM salarie WHERE id = ?");
            preparedStatement.setLong(1, salarie.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salarie supprimé avec succès");
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SalarieController.class.getName());
            logger.log(Level.SEVERE, messageErreur, e);
        }
    }

    // Pour afficher tous les salariés
    public List<Salarie>afficheSalaries() {
        ArrayList<Salarie> salaries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement("SELECT * FROM salarie");
            ResultSet resultSet =   preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                Role role = Role.valueOf(resultSet.getString("role"));
                String departement = resultSet.getString("departement");
                Salarie salarie = new Salarie(id, nom, prenom, role, departement);
                salaries.add(salarie);
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SalarieController.class.getName());
            logger.log(Level.SEVERE, "Erreur lors de l'affichage des salariés", e);
        }
return salaries;
    }

    // Pour afficher un salarié
    public Salarie affUnSalarie(Long id) {
        Salarie salarie = null;
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement("SELECT * FROM salarie WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                Role role = Role.valueOf(resultSet.getString("role"));
                String departement = resultSet.getString("departement");
                salarie = new Salarie(id, nom, prenom, role, departement);
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SalarieController.class.getName());
            logger.log(Level.SEVERE, "Erreur lors de l'affichage du salarié", e);
        }
        return salarie;
    }
}


