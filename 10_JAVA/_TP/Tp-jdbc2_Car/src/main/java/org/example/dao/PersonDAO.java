package org.example.dao;



import org.example.models.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO extends BaseDAO<Person> {

    public PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Person person) {
        request = "INSERT INTO jdbcCar.person (firstName, lastName, age) VALUES (?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request,  Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            int nbRows = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                person.setIdPerson(resultSet.getInt(1));
            }
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Person getById(int id) {
        Person person;
        request = "SELECT * FROM jdbcCar.person WHERE idPerson = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person = new Person(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getInt("age"));
                System.out.println("id : " + resultSet.getInt("id"));
                System.out.println("firstName : " + resultSet.getString("firstName"));
                System.out.println("lastName : " + resultSet.getString("lastName"));
                System.out.println("age : " + resultSet.getInt("age"));
                return person;
            } else {
                System.out.println("La personne n'existe pas");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void findAll() throws SQLException {
        request = "SELECT * FROM jdbcCar.person";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("idPerson : " + resultSet.getInt("idPerson"));
                System.out.println("Nom : " + resultSet.getString("firstName"));
                System.out.println("Prénom : " + resultSet.getString("lastName"));
                System.out.println("Age : " + resultSet.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Person findById(int id) throws SQLException {
        Person person ;
        request = "SELECT * FROM jdbcCar.person WHERE idPerson = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            person = new Person(resultSet.getInt("idPerson"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getInt("age"));
            System.out.println("idPerson : " + resultSet.getInt("idPerson"));
            System.out.println("Prénom : " + resultSet.getString("firstName"));
            System.out.println("Nom : " + resultSet.getString("lastName"));
            System.out.println("Age : " + resultSet.getInt("age"));
            return person;
        } else {
            return null;
        }
    }

    @Override
    public void update(Person person) {
        request = "UPDATE jdbcCar.person SET firstName = ?, lastName = ?, age = ? WHERE idPerson = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.setInt(4, person.getIdPerson());
            int nbRows = statement.executeUpdate();
            if (nbRows == 1) {
                System.out.println("La personne a bien été modifiée");
            } else {
                System.out.println("La personne n'existe pas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) throws SQLException {
        request = "DELETE FROM jdbcCar.person WHERE idPerson = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            int nbRows = statement.executeUpdate();
            if (nbRows == 1) {
                System.out.println("La personne a bien été supprimée");
                return true;
            } else {
                System.out.println("La personne n'existe pas");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}