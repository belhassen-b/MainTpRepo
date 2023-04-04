package org.example.heritage;

public class CompteEpargne extends CompteBancaire{

    private double decouvert;

    private double tauxInteret;

    public CompteEpargne() {
    }

    public CompteEpargne(double solde,double tauxInteret, double decouvert) {
        super(solde);
        this.tauxInteret = tauxInteret;
        this.decouvert = decouvert;
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

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }


    @Override
    public String toString() {
        return "CompteEpargne{" +
                "decouvert=" + decouvert +
                "tauxInteret=" + tauxInteret +
                ", codeBanc=" + this.getCodeBanc() +
                ", solde=" + this.getSolde() +
                '}';
    }

}
