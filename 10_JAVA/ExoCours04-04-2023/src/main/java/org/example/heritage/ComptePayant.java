package org.example.heritage;

public class ComptePayant extends CompteBancaire{



    private double decouvert;
    private double operations;

    public ComptePayant() {
    }

    public ComptePayant(double solde) {
        super(solde);
    }

        public ComptePayant(double solde, double operations, double decouvert) {
        super(solde);
        this.operations = operations;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
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
        if (this.getSolde() < this.getDecouvert()) {
            System.out.println("Solde insuffisant");
        }
    }

    @Override
    public String toString() {
        return "ComptePayant{" +
                "decouvert=" + decouvert +
                "operations=" + operations +
                ", codeBanc=" + this.getCodeBanc() +
                ", solde=" + this.getSolde() +
                '}';
    }
}
