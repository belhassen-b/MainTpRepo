package org.example.heritage;

public class CompteEpargne extends CompteBancaire{

    private double tauxInteret;

    public CompteEpargne() {
    }

    public CompteEpargne(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne(double solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {
        this.setSolde(this.getSolde() + (this.getSolde() * this.getTauxInteret()));
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "tauxInteret=" + tauxInteret +
                ", codeBanc=" + this.getCodeBanc() +
                ", solde=" + this.getSolde() +
                '}';
    }

}
