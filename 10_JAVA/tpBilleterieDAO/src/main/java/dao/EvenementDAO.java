package dao;

import entity.Evenement;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO extends BaseDAO<Evenement> {
    public EvenementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Evenement evenement) throws ExecutionControl.NotImplementedException, SQLException {
        request = "INSERT INTO evenement (nameEvent, date, time, idLocation, price, ticketsSold) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, evenement.getNameEvent());
            statement.setString(2, evenement.getDate());
            statement.setString(3, evenement.getTime());
            statement.setInt(4, evenement.getIdLocation());
            statement.setDouble(5, evenement.getPrice());
            statement.setInt(6, evenement.getTicketsSold());

            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Evenement getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        Evenement evenement = null;
        request = "SELECT * FROM evenement WHERE idEvent = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                evenement = new Evenement(
                        resultSet.getInt("idEvent"),
                        resultSet.getString("nameEvent"),
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getInt("idLocation"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("ticketsSold")
                );
            }
            return evenement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Evenement element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "UPDATE evenement SET nameEvent = ?, date = ?, time = ?, idLocation = ?, price = ?, ticketsSold = ? WHERE idEvent = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getNameEvent());
            statement.setString(2, element.getDate());
            statement.setString(3, element.getTime());
            statement.setInt(4, element.getIdLocation());
            statement.setDouble(5, element.getPrice());
            statement.setInt(6, element.getTicketsSold());
            statement.setInt(7, element.getIdEvent());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Evenement> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        List<Evenement> evenement = new ArrayList<>();
        request = "SELECT * FROM evenement";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
        evenement.add(new Evenement(
                        resultSet.getInt("idEvent"),
                        resultSet.getString("nameEvent"),
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getInt("idLocation"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("ticketsSold")
                ));
            }
            return evenement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean deleteById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        request = "DELETE FROM evenement WHERE idEvent = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}