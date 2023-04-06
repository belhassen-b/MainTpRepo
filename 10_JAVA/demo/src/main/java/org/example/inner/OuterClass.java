package org.example.inner;

public class OuterClass {


    private String message = "dans une classe interne";

    public static class AutreClasse {
        public void afficherMessage() {
            System.out.println("je suis une classe interne statique");
        }
    }
    public class InnerClass {
        public void afficherMessage() {
            System.out.println("je suis une classe interne non statique " + message);
        }
    }
}
