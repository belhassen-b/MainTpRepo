package org.example.gestionHotel;

import org.example.gestionHotel.enums.Statut;

public class Reservation {

    private int idReservation;
    private Statut statut;
    private Chambre chambre;
    private Client client;

    public Reservation() {}

    public Reservation(int idReservation,  Chambre chambre, Client client) {
        this.idReservation = idReservation;
        this.chambre = chambre;
        this.client = client;
        this.statut = Statut.STATUT_VALIDEE;
    }
    public int getIdReservation() { return idReservation; }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public  void afficherDetail(){
        System.out.println("Reservation : " + idReservation  + " " +  statut) ;
        System.out.println("Client : " + client.getNomClient()+ " " + client.getNumTel() );
        System.out.println("Chambre : " + chambre.getIdChambre() + " " + chambre.getCapacite() + chambre .getTarif());
    }

    public void annuler(){
        statut = Statut.STATUT_ANNULEE;
        chambre.liberer();
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", statut=" + statut +
                ", chambre=" + chambre +
                ", client=" + client +
                '}';
    }


}



