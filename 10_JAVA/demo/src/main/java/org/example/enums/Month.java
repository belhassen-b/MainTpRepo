package org.example.enums;

public enum Month {

    JANVIER(31),
    FEVRIER(28),
    MARS(31),
    AVRIL(30),
    MAI(31),
    JUIN(30),
    JUILLET(31),
    AOUT(31),
    SEPTEMBRE(30),
    OCTOBRE(31),
    NOVEMBRE(30),
    DECEMBRE(31);

    private int daysMonth;

    private Month(int day){
        this.daysMonth = day;
    }

    public int getDaysMonth(){
        return this.daysMonth;
    }


}
