package org.example.variable;

public class Variable {

    public static void getVariable() {
        byte b = 127;
        short s;
        s = 2;
        int i = 4;
        System.out.println("la valeure de i est : " + i);
        i = b;
        System.out.println("la valeur de i est:" + i);
        ;

        char c = 'a';

        boolean bool = true;
        int i2 = 350;
        float f = 1.45F;
        long l = 123456789L;
        double d = 1.3;

        d = f;
        l = i;
        d = i;

        byte bb = 1;
        bb = (byte) i2;
        System.out.println("la valeur de bb est:" + bb);

        long num = 123_456_789_0123_456_789L;

    }
}
