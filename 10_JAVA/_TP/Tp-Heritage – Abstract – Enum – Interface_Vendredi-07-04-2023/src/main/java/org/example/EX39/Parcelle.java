package org.example.EX39;

public class Parcelle {
    private int idParcelle;
    private int surface;

    public Parcelle() {
        this.idParcelle = idParcelle;
        this.surface = surface;
    }

    public int getIdParcelle() {
        return idParcelle;
    }

    public void setIdParcelle(int idParcelle) {
        this.idParcelle = idParcelle;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Parcelle{" +
                "idParcelle=" + idParcelle +
                ", surface=" + surface +
                '}';
    }


}
