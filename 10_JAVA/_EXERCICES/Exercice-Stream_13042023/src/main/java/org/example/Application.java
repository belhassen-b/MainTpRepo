package org.example;

import org.example.trader.Trader;
import org.example.transaction.Transaction;

import javax.naming.Name;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main() {
        Trader abdallah = new Trader("Abdallah", "Cambridge");
        Trader audrey = new Trader("Audrey", "Milan");
        Trader corentin = new Trader("Corentin", "Cambridge");
        Trader tristan = new Trader("Tristan", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(abdallah, 2011, 400),
                new Transaction(abdallah, 2011, 250),
                new Transaction(abdallah, 2012, 600),
                new Transaction(audrey, 2011, 400),
                new Transaction(audrey, 2011, 700),
                new Transaction(audrey, 2012, 1000),
                new Transaction(corentin, 2012, 710),
                new Transaction(corentin, 2012, 700),
                new Transaction(corentin, 2012, 950),
                new Transaction(tristan, 2011, 950),
                new Transaction(tristan, 2012, 900),
                new Transaction(tristan, 2022, 1900)
        );

        System.out.println("1 transactions en 2011 et trier par valeur croissante");

        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .forEach(System.out::println);

        System.out.println("*********************");
        System.out.println("2 villes des traders");

        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println("---- Avec set-----");
        Set<Transaction> transactionsSet = new HashSet<>(transactions);

        for (Transaction city : transactionsSet) {

            System.out.println(city.getTrader().getCity());
        }

        System.out.println("*********************");
        System.out.println("3  Noms des traders triés par ordre alphabétique");

        List<String> listeTriee = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listeTriee);

        System.out.println("*********************");
        System.out.println("4  Y-a-t-il un trader basé à Milan ?");

        boolean milan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        if (milan) {
            System.out.println("Oui; un trader est basé à Milan");
            System.out.println("Il s'agit de : " + transactions.stream()
                    .filter(t -> t.getTrader().getCity().equals("Milan"))
                    .map(t -> t.getTrader().getName())
                    .findFirst().get());
        } else {
            System.out.println("Non");
        }

        System.out.println("*********************");
        System.out.println("5  La valeur des transactions la plus élévée");
        Optional<Integer> max = transactions.stream()
                .map(t -> t.getValue())
                .max(Integer::compareTo);
        System.out.println("La valeur max des transactions est : " + max.get());


        System.out.println("*********************");
        System.out.println("6 Les traders de Cambridge triés par nom");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);

        System.out.println("*********************");
        System.out.println("7  La valeur des transactions des traders de Cambridge");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName() + " : " + t.getValue())
                .forEach(System.out::println);

        System.out.println("*********************");
        System.out.println("8  La valeur des transactions la plus basse");
        transactions.stream()
                .map(t -> t.getValue())
                .min(Integer::compareTo)
                .ifPresent(System.out::println);


        System.out.println("*********************");
        System.out.println("9 Les commerçants qui ont augmenté leur valeur de transaction au fil du temps");

        transactions.stream()
                .filter(t -> t.getYear()>=2011)
                .filter(t -> t.getYear()<=2022)
                .map(t -> t.getTrader().getName() + " : " + t.getValue())
                .distinct();
        Optional<Integer> max2 = transactions.stream()
                .map(t -> t.getValue())
                .max(Integer::compareTo);
        Optional<Integer> min = transactions.stream()
                .map(t -> t.getValue())
                .min(Integer::compareTo);
System.out.println("La valeur max des transactions est : " + max2.get());
        System.out.println("La valeur min des transactions est : " + min.get());
        System.out.println("La différence est de : " + (max2.get()-min.get()));
        System.out.println("les traders qui ont augmenté leur valeur de transaction au fil du temps sont :" + transactions.stream()
                .filter(t -> max2.get()>(min.get()))
                .map(t -> t.getTrader().getName())
                .distinct()
                .collect(Collectors.toList()));

    }
}