package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_dossierMedical;
    private String reference_dossierMedical;
    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    public DossierMedical(){

    }

    public DossierMedical(String reference_dossierMedical) {
        this.reference_dossierMedical = reference_dossierMedical;
    }

    public DossierMedical(Patient patient, List<Consultation> consultations) {
        this.patient = patient;
        this.consultations = consultations;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public int getId_dossierMedical() {
        return id_dossierMedical;
    }

    public void setId_dossierMedical(int id_dossierMedical) {
        this.id_dossierMedical = id_dossierMedical;
    }

    public String getReference_dossierMedical() {
        return reference_dossierMedical;
    }

    public void setReference_dossierMedical(String reference_dossierMedical) {
        this.reference_dossierMedical = reference_dossierMedical;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "id_dossierMedical=" + id_dossierMedical +
                ", reference_dossierMedical='" + reference_dossierMedical + '\'' +
                ", patient=" + patient +
                ", consultations=" + consultations +
                '}';
    }
}