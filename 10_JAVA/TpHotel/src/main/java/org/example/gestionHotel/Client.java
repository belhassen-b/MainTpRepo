package org.example.gestionHotel;

public class Client {


    private String nomClient;

    private String prenomClient;

    private String numTelClientReservation;

    public Client() {
    }

    public Client(String nomClient, String prenomClient, String numTelClientReservation) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numTelClientReservation = numTelClientReservation;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getNumTelClientReservation() {
        return numTelClientReservation;
    }

    public void setNumTelClientReservation(String numTelClientReservation) {
        this.numTelClientReservation = numTelClientReservation;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", numTelClientReservation='" + numTelClientReservation + '\'' +
                '}';
    }
}
