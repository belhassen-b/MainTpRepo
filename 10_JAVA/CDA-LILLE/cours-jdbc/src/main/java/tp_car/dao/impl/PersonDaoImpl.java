package tp_car.dao.impl;

import tp_car.config.DatabaseSingleton;
import tp_car.dao.IGenericDao;
import tp_car.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class PersonDaoImpl implements IGenericDao<Person> {
    private Connection connection;

    public PersonDaoImpl() {
    this.connection = DatabaseSingleton.getInstance().getConnection();
    }

    @Override
    public Person save(Person type) throws SQLException {
     String sql = "INSERT INTO person (name, firstname, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, RETURN_GENERATED_KEYS)) {
            statement.setString(1, type.getFirstName());
            statement.setString(2, type.getLastName());
            statement.setInt(3, type.getAge());
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
    public Person findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person update(Person type) {
        return null;
    }
}
