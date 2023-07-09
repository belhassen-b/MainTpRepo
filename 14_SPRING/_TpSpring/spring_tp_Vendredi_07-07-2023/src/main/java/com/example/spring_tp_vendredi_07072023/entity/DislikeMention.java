package com.example.spring_tp_vendredi_07072023.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DislikeMention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Date must be in the format dd-mm-yyyy")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Comment comment;

}

