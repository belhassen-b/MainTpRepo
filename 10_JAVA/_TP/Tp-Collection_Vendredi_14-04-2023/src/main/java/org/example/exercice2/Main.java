package org.example.exercice2;

import org.example.enums.Order;


import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        DemoCercle.addCercle(liste);


        public static void triOrder(Order order, List<DemoCercle> liste) {
            CercleComparator comparator = new CercleComparator();
            comparator.setOrder(order);
            Collections.sort(liste, comparator);
        }
    }



