package org.example.model;


import javax.persistence.*;

@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long agencyId;

    private String agencyAddress;

    public Agency() {
        // default constructor

    }

    public Long getAgencyId() {
        return agencyId;
    }

    public String getAddress() {
        return agencyAddress;
    }

    public void setAddress(String address) {
        this.agencyAddress = address;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "agencyId=" + agencyId +
                ", agencyAddress='" + agencyAddress + '\'' +
                '}';
    }

}
