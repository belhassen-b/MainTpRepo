package org.example.exercice5Bis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voiture {

    private int rentDueIn;
    private int condition;
    private boolean isLuxury;
    private boolean isOldCar;
}
