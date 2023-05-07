package tpJDBC2.dao;

import jdk.jshell.spi.ExecutionControl;
import tpJDBC2.models.Car;
import tpJDBC2.models.Sell;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SellDAO extends BaseDAO<Sell> {

    public SellDAO(Connection connection) {
        super(connection);
    }


    public boolean create(Sell sell) throws SQLException {
        request = "INSERT INTO sell ( idCar, idPerson, date) VALUES (?,?,?)";
        try {
            statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, sell.getIdCar());
            statement.setInt(2, sell.getIdPerson());
            statement.setString(3, sell.getDate());
            int nbRows = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                sell.setIdSell(resultSet.getInt(1));
            }
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Sell> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        request = "SELECT * FROM sell";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("idSell : " + resultSet.getInt("idSell"));
                System.out.println("idCar : " + resultSet.getInt("idCar"));
                System.out.println("idPerson : " + resultSet.getInt("idPerson"));
                System.out.println("date : " + resultSet.getString("date"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Sell getByPerson(int idPerson) throws SQLException {
        request = "SELECT * FROM sell WHERE idPerson = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, idPerson);
            resultSet = statement.executeQuery();
            if (resultSet.next())  {
                System.out.println("Liste des voitures vendues pour un acheteur : " + resultSet.getInt("idPerson"));
                System.out.println("idSell : " + resultSet.getInt("idSell"));
                System.out.println("idCar : " + resultSet.getInt("idCar"));
                System.out.println("date : " + resultSet.getString("date"));

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}