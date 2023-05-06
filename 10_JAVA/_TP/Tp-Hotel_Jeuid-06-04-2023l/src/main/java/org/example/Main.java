package org.example;


import org.example.gestionHotel.Hotel;
import org.example.gestionHotel.Ihm;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Bates Motel");
        Ihm ihm = new Ihm( hotel);
        ihm.lancer();
    }
}