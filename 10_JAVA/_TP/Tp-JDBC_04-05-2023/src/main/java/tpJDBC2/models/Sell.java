package tpJDBC2.models;


import java.util.Date;

public class Sell {

    private int idSell;
    private int idPerson;
    private int idCar;
    private String date;

    public Sell(int idPerson, int idCar, String date) {
        this.idPerson = idPerson;
        this.idCar = idCar;
        this.date = this.date;
    }

    public Sell(int idSell, int idPerson, int idCar, String date) {
        this(idPerson, idCar, date);
        this.idSell = idSell;
    }


    public int getIdSell() {
        return idSell;
    }

    public void setIdSell(int idSell) {
        this.idSell = idSell;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}