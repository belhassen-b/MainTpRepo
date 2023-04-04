package org.example.house;

public class House {


    private int surface;
    private int door;

    private String doorColor;


    public House(int surface, int door, String doorColor) {
        this.surface = surface;
        this.door = door;
        this.doorColor = doorColor;
         }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getDoorColor() {
        return doorColor;
    }

    public void setDoorColor(String doorColor) {
        this.doorColor = doorColor;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

   @Override
    public String toString() {
        return "Je suis une"  + getClass().getSimpleName() + " et ma surface est de " + surface + "m2";
    }

    public void DisplayDoor() {
        System.out.println("Je suis une porte et ma couleur est :" + doorColor);
    }

    public void DisplayHouse() {
        if( getClass().getSimpleName() == "House")
        System.out.println("Je suis une maison  et ma surface est de " + surface + "m2");
        else
            System.out.println("Je suis un appartement  et ma surface est de " + surface + "m2");
    }
}
