package org.example.exercice6;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LePendu {
    private int nbEssai;
    private String masque;
    private String motATrouve;

    public void genererMasque(IGenerateur generateurMot) throws Exception {
        motATrouve = generateurMot.generer();
        if (motATrouve == null || motATrouve.equals("")) {
            throw new Exception();
        }
        masque = "";
        for (int i = 0; i < motATrouve.length(); i++) {
            masque += "*";
        }

}

    public boolean testChar(char c) throws Exception {
        throw new Exception();
    }

    public boolean testWin() throws Exception {
        throw new Exception();
    }
}
