package tpJDBC2.models;

public class Car {

    private int idCar;
    private String name;
    private String year;

    private int power;
    private int price;

    public Car(int idCar, String name, String year, int power, int price) {
        this.idCar = idCar;
        this.name = name;
        this.year = year;
        this.power = power;
        this.price = price;
    }
    public Car(String name, String year, int power, int price) {
        this.name = name;
        this.year = year;
        this.power = power;
        this.price = price;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
