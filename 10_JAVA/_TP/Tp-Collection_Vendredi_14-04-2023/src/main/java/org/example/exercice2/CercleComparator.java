package org.example.exercice2;

import org.example.enums.Order;

public class CercleComparator implements java.util.Comparator<Cercle> {
    Order order;
    @Override
    public int compare(Cercle o1, Cercle o2) {
        switch (order) {
            case RAYON:
                return Double.compare(o1.getRayon(), o2.getRayon());
            case ABSCISSE:
                return Integer.compare(o1.getX(), o2.getX());
            default:
                return Double.compare(o1.getRayon(), o2.getRayon());
        }
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}

