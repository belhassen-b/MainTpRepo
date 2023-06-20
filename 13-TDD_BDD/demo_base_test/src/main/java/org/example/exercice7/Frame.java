package org.example.exercice7;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Frame {
    private int score;
    private boolean _lastFrame;
    private IGenerateur _generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        _lastFrame = lastFrame;
        _generateur = generateur;
    }

    public boolean makeRoll(IGenerateur generateur) throws Exception {
        int pins = _generateur.randomPin(10);
        if (pins > 10) {
            throw new Exception();
        }
        score += pins;
        throw new Exception();
    }
}
