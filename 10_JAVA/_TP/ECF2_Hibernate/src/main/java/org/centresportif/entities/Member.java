package org.centresportif.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Member {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;

    private String firstName;


    @ManyToMany(mappedBy = "members", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Activity> activities = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setActivity(Activity activity) {
        this.activities.add(activity);
    }
}


