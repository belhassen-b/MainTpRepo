package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_patient;
    private String nom_patient;
    private String prenom_patient;
    private String mail_patient;
    private String tel_patient;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private DossierMedical dossierMedical;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Consultation> consultations;


    public Patient(){

    }

    public Patient(String nom_patient, String prenom_patient, String mail_patient, String tel_patient, List<Consultation> consultations) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.mail_patient = mail_patient;
        this.tel_patient = tel_patient;
        this.consultations = consultations;
    }

    public Patient(String nom_patient, String prenom_patient, String mail_patient, String tel_patient) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.mail_patient = mail_patient;
        this.tel_patient = tel_patient;
    }

    public Patient(String nom_patient, String prenom_patient, String mail_patient, String tel_patient, DossierMedical dossierMedical) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.mail_patient = mail_patient;
        this.tel_patient = tel_patient;
        this.dossierMedical = dossierMedical;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public void setNom_patient(String nom_patient) {
        this.nom_patient = nom_patient;
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public void setPrenom_patient(String prenom_patient) {
        this.prenom_patient = prenom_patient;
    }

    public String getMail_patient() {
        return mail_patient;
    }

    public void setMail_patient(String mail_patient) {
        this.mail_patient = mail_patient;
    }

    public String getTel_patient() {
        return tel_patient;
    }

    public void setTel_patient(String tel_patient) {
        this.tel_patient = tel_patient;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id_patient=" + id_patient +
                ", nom_patient='" + nom_patient + '\'' +
                ", prenom_patient='" + prenom_patient + '\'' +
                ", mail_patient='" + mail_patient + '\'' +
                ", tel_patient='" + tel_patient + '\'' +
                ", dossierMedical=" + dossierMedical +
                ", consultations=" + consultations +
                '}';
    }
}
