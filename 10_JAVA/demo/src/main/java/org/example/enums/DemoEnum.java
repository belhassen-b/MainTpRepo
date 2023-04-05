package org.example.enums;

public class DemoEnum {
    public static void main() {

        Priority priority = Priority.HIGH;

        switch (priority){
            case HIGH:
                System.out.println("High Priority");
                break;
            case MEDIUM:
                System.out.println("High Medium");
                break;
            case LOW:
                System.out.println("High Low");
                break;
        }
        Priority priority1 = Priority.valueOf("HIGH");
        System.out.println(priority1);

        Priority[] priorities = Priority.values();

        for (Priority prio: priorities) {
            System.out.println("Enum  : " + prio);
        }


        System.out.println("Nombre de jour pour le mois de Janvier : " + Month.JANVIER.getDaysMonth());

    }


}
