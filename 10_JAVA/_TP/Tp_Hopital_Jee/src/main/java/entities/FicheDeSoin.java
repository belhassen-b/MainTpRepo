package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_ficheDeSoin;
    private String description_ficheSoin;

    public FicheDeSoin() {
    }

    public FicheDeSoin(String description_ficheSoin) {
        this.description_ficheSoin = description_ficheSoin;
    }

    public int getId_ficheDeSoin() {
        return id_ficheDeSoin;
    }

    public void setId_ficheDeSoin(int id_ficheDeSoin) {
        this.id_ficheDeSoin = id_ficheDeSoin;
    }

    public String getDescription_ficheSoin() {
        return description_ficheSoin;
    }

    public void setDescription_ficheSoin(String description_ficheSoin) {
        this.description_ficheSoin = description_ficheSoin;
    }

    @Override
    public String toString() {
        return "FicheDeSoin{" +
                "id_ficheDeSoin=" + id_ficheDeSoin +
                ", description_ficheSoin='" + description_ficheSoin + '\'' +
                '}';
    }
}