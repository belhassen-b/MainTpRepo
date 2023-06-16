package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_prescription;
    private String medicament_prescription;

    public Prescription() {
    }

    public Prescription(String medicament_prescription) {
        this.medicament_prescription = medicament_prescription;
    }

    public int getId_prescription() {
        return id_prescription;
    }

    public void setId_prescription(int id_prescription) {
        this.id_prescription = id_prescription;
    }

    public String getMedicament_prescription() {
        return medicament_prescription;
    }

    public void setMedicament_prescription(String medicament_prescription) {
        this.medicament_prescription = medicament_prescription;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id_prescription=" + id_prescription +
                ", medicament_prescription='" + medicament_prescription + '\'' +
                '}';
    }
}