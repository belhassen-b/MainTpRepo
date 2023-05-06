package dao;

import entity.Ticket;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends BaseDAO<Ticket> {

    public TicketDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ticket element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "INSERT INTO ticket (idClient, idEvenement, nbTickets) VALUES (?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdClient());
            statement.setInt(2, element.getIdEvenement());
            statement.setInt(3, element.getNbTickets());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Ticket getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        Ticket ticket = null;
        request = "SELECT * FROM ticket WHERE id = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("idEvenement"),
                        resultSet.getInt("nbTickets")
                );
            }
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Ticket element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "UPDATE ticket SET idClient = ?,  idEvenement = ?, nbTickets = ?  WHERE id = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdClient());
            statement.setInt(2, element.getIdEvenement());
            statement.setInt(3, element.getNbTickets());
            statement.setInt(4, element.getId());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Ticket> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        request = "SELECT * FROM ticket";
        List<Ticket> tickets = new ArrayList<>();
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("idEvenement"),
                        resultSet.getInt("nbTickets")
                );
                tickets.add(ticket);
            }
            return tickets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        request = "DELETE FROM ticket WHERE id = ?";
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
    public List<Ticket> getAllByUserId(int id) throws ExecutionControl.NotImplementedException, SQLException {
        List<Ticket> tickets = new ArrayList<>();
        request = "SELECT * FROM ticket WHERE idClient = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("idEvenement"),
                        resultSet.getInt("nbTickets")
                );
        tickets.add(ticket);
            }
                return tickets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEventById(int id) {
        request = "SELECT * FROM evenement WHERE id = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("nom");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getNbTicketsById(int id) {
        request = "SELECT * FROM ticket WHERE id = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("nbTickets");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

