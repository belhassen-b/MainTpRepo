package org.example.methode;

import java.util.Scanner;

public class MethodParam {
    public static void changeValue(int i) {
        i += 100;
        System.out.println("i = " + i);
    }

    public static void changeArray(int[] array) {
        array[0] = 200;
        System.out.println("array[0] = " + array[0]);

    }

    public static void changeArray(int[] array, int val) {
        array[1] = 200;
    }

    public int sum(int i, int j, int l) {
        return i + j + l;
    }

    public int sum2(int... ints) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return sum;
    }

    public int[] optab(int[] tab, int tabn[]) {
        return tab;
    }

    public static int multi(int a, int b) {
        if (b == 0) return 0;
        return a + multi(a, b - 1);
    }

    public static int factorielle(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * factorielle(f - 1);
        }
    }

    public static int multiplication(int a, int b) {
        if (b == 0) return 0;
        return a + multiplication(a, b - 1);
    }
}
