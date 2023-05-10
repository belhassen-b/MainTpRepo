package tp_car.dao.impl;

import tp_car.config.DatabaseSingleton;
import tp_car.dao.IGenericDao;
import tp_car.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CarDaoImpl  implements IGenericDao<Car> {

    private Connection connection;


    public CarDaoImpl() {
        this.connection = DatabaseSingleton.getInstance().getConnection();
    }

    @Override
    public Car save(Car type) throws SQLException {
        String sql = "INSERT INTO car (model, power, price, year) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, RETURN_GENERATED_KEYS)) {
            statement.setString(1, type.getModel());
            statement.setInt(2, type.getPower());
            statement.setDouble(3, type.getPrice());
            statement.setString(4, type.getYear());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                type.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return type;
    }
    @Override
    public Car findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Car update(Car type) {
        return null;
    }
}
