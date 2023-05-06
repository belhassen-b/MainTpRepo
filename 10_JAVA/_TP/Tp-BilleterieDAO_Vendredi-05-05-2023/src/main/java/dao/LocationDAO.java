package dao;

import entity.Location;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class LocationDAO extends BaseDAO<Location> {
    public LocationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Location element) throws ExecutionControl.NotImplementedException, SQLException {
        request  = "INSERT INTO location (name, address, capacity) VALUES (?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getName());
            statement.setString(2, element.getAddress());
            statement.setInt(3, element.getCapacity());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Location getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        Location location = null;
        request = "SELECT * FROM location WHERE idLocation = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = new Location(
                        resultSet.getInt("idLocation"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
            }
            return location;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public boolean update(Location element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "UPDATE location SET name = ?, address = ?, capacity = ? WHERE id= ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getName());
            statement.setString(2, element.getAddress());
            statement.setInt(3, element.getCapacity());
            statement.setInt(4, element.getId());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Location> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        List<Location> location = new ArrayList<>();
        request = "SELECT * FROM location";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(
                        resultSet.getInt("idLocation"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
                location.add(l);
            }
            return location;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        request = "DELETE FROM location WHERE id = ?";
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
