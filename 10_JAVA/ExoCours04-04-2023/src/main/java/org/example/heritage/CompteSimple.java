package org.example.heritage;

public class CompteSimple extends CompteBancaire{

    private double decouvert;

    public CompteSimple() {
        super();
    }

    public CompteSimple(double solde, double decouvert) {
        super(solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public void retrait(double montant) {
              this.setSolde(this.getSolde() - montant);
        }

    @Override
    public String toString() {
        return "CompteSimple{" +
                "decouvert=" + decouvert +
                ", codeBanc=" + this.getCodeBanc() +
                ", solde=" + this.getSolde() +
                '}';
    }

    public static void main(String[] args) {

    }
}
