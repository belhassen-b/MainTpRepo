package tp_car.service;

import org.example.util.DataBaseManager;
import tp_car.dao.PersonDAO;
import tp_car.entity.Person;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonService {
    private PersonDAO personDAO;
    private Connection connection;

    public PersonService() {
        try {
            connection = new DataBaseManager().getConnection();
            personDAO = new PersonDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createPerson(String firstName, String lastName, int age) {
        Person person = new Person(firstName, lastName, age);
        try {
            if(personDAO.save(person)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updatePerson(int id, String firstName, String lastName, int age) {
        try {
            Person person = getPerson(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setAge(age);
            if(personDAO.update(person)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Person getPerson(int id) {
        try {
            return personDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletePerson(int id) {
        Person person = null;
        try {
            person = personDAO.get(id);
            if(person != null) {
                return personDAO.delete(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Person> getAllPersons() {
        try {
            return personDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
