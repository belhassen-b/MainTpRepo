package org.example.gestionHotel;

public class Reservation {

    private int idReservation;

    private boolean statut;

    private String numTelClientReservation;

    private int idChambre;

    private int idHotel;

    private int numChambreReservation;

    private boolean statutReservation;


public Reservation(){

    }


    public Reservation(int idReservation, boolean statut, String numTelClientReservation, int idChambre, int idHotel, int numChambreReservation, boolean statutReservation) {
        this.idReservation = idReservation;
        this.statut = statut;
        this.numTelClientReservation = numTelClientReservation;
        this.idChambre = idChambre;
        this.idHotel = idHotel;
        this.numChambreReservation = numChambreReservation;
        this.statutReservation = statutReservation;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public boolean isStatut() {
        return statut;
    }

public void setStatut(boolean statut) {
        this.statut = statut;
    }


    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNumTelClientReservation() {
        return numTelClientReservation;
    }

    public void setNumTelClientReservation(String numTelClientReservation) {
        this.numTelClientReservation = numTelClientReservation;
    }

    public int getNumChambreReservation() {
        return numChambreReservation;
    }

    public void setNumChambreReservation(int numChambreReservation) {
        this.numChambreReservation = numChambreReservation;
    }

    public boolean isStatutReservation() {
        return statutReservation;
    }

    public void setStatutReservation(boolean statutReservation) {
        this.statutReservation = statutReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", statut=" + statut +
                ", numTelClientReservation='" + numTelClientReservation + '\'' +
                ", idChambre=" + idChambre +
                ", idHotel=" + idHotel +
                '}';
    }


}



