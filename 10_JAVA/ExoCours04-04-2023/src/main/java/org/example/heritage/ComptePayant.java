package org.example.heritage;

public class ComptePayant extends CompteBancaire{

    private double operations;

    public ComptePayant() {
    }

    public ComptePayant(double solde) {
        super(solde);
    }

    public ComptePayant(double solde, double operations) {
        super(solde);
        this.operations = operations;
    }




    public double getOperations() {
        return operations;
    }

    public void setOperations(double operations) {
        this.operations = operations;
    }

    public void versement(double montant) {
        this.setSolde(this.getSolde() + montant - this.getOperations());
    }

    public void retrait(double montant) {
        this.setSolde(this.getSolde() - montant - this.getOperations());
    }

    @Override
    public String toString() {
        return "ComptePayant{" +
                "operations=" + operations +
                ", codeBanc=" + this.getCodeBanc() +
                ", solde=" + this.getSolde() +
                '}';
    }
}
