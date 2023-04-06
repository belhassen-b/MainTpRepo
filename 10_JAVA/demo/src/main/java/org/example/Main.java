package org.example;

import org.example.inner.OuterClass;
import org.example.methode.MethodParam;
import org.example.operator.Operator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Variable.getVariable();
//        Operator.getOperator();
//        Operator.getExpressionType();
//        Operator.getOperationAndCompaison();
        ;


//    Maison maison1 = new Maison(12, "maison1");
//    Maison maison2 = new Maison(12, "maison1");
//    System .out.println("maison1 == maison2 : " + (maison1 == maison2));
//        System.out.println("maison1==maison2 : " + (maison1.nom == maison2.nom));

//Operator.demoSysteme();
//
//        System.out.println("Saisir un nobre pour calculer la factorielle");
//        Scanner scanner = new Scanner(System.in);
//        int f = scanner.nextInt();
//        System.out.println("factorielle de " + f + " = " + MethodParam.factorielle(f));
//
//        System.out.println("Saisir un nobre pour calculer la multiplication");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        for (int i = 0; i < 10; i++) {
//           System.out.println("multiplication de " + a + " * " + b + " = " + MethodParam.multiplication(a, b));
//        }

//         OuterClass outerClass = new OuterClass();
//         OuterClass.InnerClass innerClass = outerClass.new InnerClass();
//            innerClass.afficherMessage();

        OuterClass.AutreClasse autreClasse = new OuterClass.AutreClasse();
        autreClasse.afficherMessage();

    }

}

