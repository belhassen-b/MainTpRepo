package org.example.exercice5Bis;

public class Agence {
    public void dailyRoutine(Voiture voiture) {

        if (voiture.isOldCar() == true) {
            if (voiture.getRentDueIn() > 0 && voiture.getCondition() > 0 && voiture.getCondition() <= 100) {
                voiture.setRentDueIn(voiture.getRentDueIn() - 1);
                voiture.setCondition(voiture.getCondition() - 2);
            } else if ((voiture.getRentDueIn() == 0) && (voiture.getCondition() > 0) && (voiture.getCondition() <= 100)) {
                voiture.isOldCar();
                voiture.setCondition(voiture.getCondition() - 2);
            }
        } else if (voiture.isLuxury() == true) {
            if (voiture.getRentDueIn() > 0 && voiture.getCondition() > 0 && voiture.getCondition() <= 100) {
                voiture.setRentDueIn(voiture.getRentDueIn() - 1);
                voiture.setCondition(voiture.getCondition() + 1);
            } else if (voiture.getRentDueIn() == 0 && voiture.getCondition() > 0 && voiture.getCondition() <= 100) {
                voiture.isLuxury();
                voiture.setCondition(voiture.getCondition() + 1);
            }
        } else {
            if (voiture.getRentDueIn() > 0 && voiture.getCondition() > 0 && voiture.getCondition() <= 100) {
                voiture.setRentDueIn(voiture.getRentDueIn() - 1);
                voiture.setCondition(voiture.getCondition() - 1);
            } else if (voiture.getRentDueIn() == 0 && voiture.getCondition() > 0 && voiture.getCondition() <= 100) {
                voiture.setCondition(voiture.getCondition() - 2);
            }
        }

    }
}


