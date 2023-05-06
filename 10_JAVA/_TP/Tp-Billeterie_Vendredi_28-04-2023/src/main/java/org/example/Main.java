package org.example;

import org.example.entity.Billeterie;
import org.example.utils.Ihm;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("src/main/java/org/example/utils/parcours.txt");
        Billeterie billeterie = new Billeterie("Billeterie");
        Ihm ihm = new Ihm(billeterie);
        ihm.run(  );



    }
}