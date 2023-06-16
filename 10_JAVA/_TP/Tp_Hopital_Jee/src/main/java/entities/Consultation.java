package entities;

import javax.persistence.*;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_consultation;
    private String nom_consultation;
    @OneToOne
    private Prescription prescription;
    @OneToOne
    private FicheDeSoin ficheDeSoin;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne()
    @JoinColumn(name="dossierMedical_id")
    private DossierMedical dossierMedical;

    public Consultation() {
    }

    public Consultation(String nom_consultation, Prescription prescription, FicheDeSoin ficheDeSoin) {
        this.nom_consultation = nom_consultation;
        this.prescription = prescription;
        this.ficheDeSoin = ficheDeSoin;
    }

    public Consultation(String nom_consultation, Prescription prescription, FicheDeSoin ficheDeSoin, Patient patient, DossierMedical dossierMedical) {
        this.nom_consultation = nom_consultation;
        this.prescription = prescription;
        this.ficheDeSoin = ficheDeSoin;
        this.patient = patient;
        this.dossierMedical = dossierMedical;
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }

    public String getNom_consultation() {
        return nom_consultation;
    }

    public void setNom_consultation(String nom_consultation) {
        this.nom_consultation = nom_consultation;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public FicheDeSoin getFicheDeSoin() {
        return ficheDeSoin;
    }

    public void setFicheDeSoin(FicheDeSoin ficheDeSoin) {
        this.ficheDeSoin = ficheDeSoin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id_consultation=" + id_consultation +
                ", nom_consultation='" + nom_consultation + '\'' +
                ", prescription=" + prescription +
                ", ficheDeSoin=" + ficheDeSoin +
                ", patient=" + patient +
                ", dossierMedical=" + dossierMedical +
                '}';
    }
}