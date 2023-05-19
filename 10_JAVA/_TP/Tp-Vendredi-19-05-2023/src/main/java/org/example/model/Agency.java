package org.example.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long agencyId;

    private String agencyName;

    private String agencyAddress;

    public Agency(String agencyName) {
        this.agencyName = agencyName;
    }

    public Agency() {

    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public void setName(String name) {
        this.agencyName = name;
    }

    public void setAddress(String address) {
        this.agencyAddress = address;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "agencyId=" + agencyId +
                ", agencyName='" + agencyName + '\'' +
                ", agencyAddress='" + agencyAddress + '\'' +
                '}';
    }

}
