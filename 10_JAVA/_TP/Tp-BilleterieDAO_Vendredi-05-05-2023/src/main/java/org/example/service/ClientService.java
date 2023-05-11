package org.example.service;
import org.example.config.DataBaseSingleton;
import org.example.dao.ClientDAO;

import org.example.entity.Client;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private Connection connection;
    private ClientDAO clientDAO;

    public ClientService(){
        try{
            connection = DataBaseSingleton.getInstance().getConnection();
            clientDAO = new ClientDAO(connection);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Client get(int idClient){
        try{
            return clientDAO.get(idClient);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean saveClient(String lastName, String firstName, String email){
        Client client = new Client();
        try{
            if(clientDAO.save(client)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateClient(int idClient, String lastName, String firstName, String email, int nbTickets){
        try {
            Client client = get(idClient);

            if (clientDAO.update(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean deleteClient(int idClient){
        Client client= null;
        try{
            client =  clientDAO.get(idClient);
            if(clientDAO.delete(client)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Client> getAllclient(){
        try{
            return clientDAO.get();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
