package org.example.model;



import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contact {

    private Long id;
    private String name;
    private String number;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
