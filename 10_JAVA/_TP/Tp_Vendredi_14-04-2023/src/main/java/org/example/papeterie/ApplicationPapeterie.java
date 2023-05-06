package org.example.papeterie;

import org.example.papeterie.facture.Papeterie;

public class ApplicationPapeterie {

    public static void main() {

        Papeterie papeterie = new Papeterie("chezmoi");
        System.out.println(papeterie.getArticles());
        System.out.println(papeterie.getClients());

    }
}
