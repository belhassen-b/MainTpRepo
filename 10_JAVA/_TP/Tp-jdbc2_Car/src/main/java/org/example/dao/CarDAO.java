package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDAO extends BaseDAO<Car> {

    public CarDAO(Connection connection) {
        super(connection);
    }
    @Override
    public boolean create(Car car) throws SQLException {
        request = "INSERT INTO jdbcCar.car ( name, year, power, price) VALUES (?,?,?,?)";
       try {
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, car.getName());
        statement.setInt(2, Integer.parseInt(car.getYear()));
        statement.setInt(3, car.getPower());
        statement.setInt(4, car.getPrice());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            car.setIdCar(resultSet.getInt(1));
        }
        return nbRows == 1;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    @Override
    public Person getById(int id) {
        return null;
    }

    @Override
    public void findAll() throws SQLException {
    request = "SELECT * FROM jdbcCar.car";
        try {
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            showCarInfo();
        }
    } catch (Exception e) {
        e.printStackTrace();

    }
}

    private void showCarInfo() throws SQLException {
        System.out.println("idCar : " + resultSet.getInt("idCar"));
        System.out.println("name : " + resultSet.getString("name"));
        System.out.println("year : " + resultSet.getInt("year"));
        System.out.println("power : " + resultSet.getInt("power") + "ch");
        System.out.println("price : " + resultSet.getInt("price") + "€");
    }


    public Car findById(int id) throws SQLException {
        Car car;
        request = "SELECT * FROM jdbcCar.car WHERE idCar = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = new Car(resultSet.getInt("idCar"), resultSet.getString("name"), resultSet.getString("year"), resultSet.getInt("power"), resultSet.getInt("price"));
                showCarInfo();
                return car;
            } else {
                return null;

            }
        }
@Override
    public void update(Car car) throws SQLException {
        request = "UPDATE jdbcCar.car SET name = ?, year = ?, power = ?, price = ? WHERE idCar = ?";
            statement = _connection.prepareStatement(request);
            statement.setString(1, car.getName());
            statement.setInt(2, Integer.parseInt(car.getYear()));
            statement.setInt(3, car.getPower());
            statement.setInt(4, car.getPrice());
            statement.setInt(5, car.getIdCar());
            int nbRows = statement.executeUpdate();
            if (nbRows == 1) {
                System.out.println("La voiture a bien été modifiée");
            } else {
                System.out.println("La voiture n'existe pas");
            }
}

    public boolean delete(int id) throws SQLException {
        request = "DELETE FROM jdbcCar.car WHERE idCar = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            int nbRows = statement.executeUpdate();
            if (nbRows == 1) {
                return true;
            } else {
                System.out.println("La voiture n'existe pas");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
