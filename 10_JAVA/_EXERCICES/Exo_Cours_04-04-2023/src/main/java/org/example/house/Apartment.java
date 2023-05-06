package org.example.house;

public class Apartment extends House{
    private int surface;
    private int door;
    private String doorColor;

    public Apartment(int surface, int door, String doorColor) {
        super(surface, door, doorColor);
    }
}
