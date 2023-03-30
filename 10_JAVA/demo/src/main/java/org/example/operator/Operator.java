package org.example.operator;

import java.util.Arrays;
import java.util.Scanner;

public class Operator {
//    public static void getOperator()    {
//        System.out.println("********** Operator **********");
//        int i = 10;
//        int i2 = -10;
//        int i3 = i++;
//        int i4 = ++i;
//        int i5 = --i;
//        int i6 = i--;
//
//
//        System.out.println("i = " + i);
//        System.out.println("i2 = " + i2);
//        System.out.println("i3 = " + i3);
//        System.out.println("i4 = " + i4);
//        System.out.println("i5 = " + i5);
//        System.out.println("i6 = " + i6);

        public static void getExpressionType() {
byte b = 1;
short s = 1;
int i = 1;
long l = 1;
float f = 1.0f;
double d = 1.0;
char c = 1  ;
       int express1 = b + b;
         int express2 = s + b;
            int express3 = i + b + c;
            long express4 = l +i;
            float express5 = f + l;
            double express6 = d + f;

            int t1 = 2_000_215_687;
            int t2 = 2_000_215_687;
            int t3 = t1 + t2;
            System.out.println("t3 = " + t3);
            double t4 = t1 + t2;
            System.out.println("t4 = " + t4);
        }


        public static void getOperationAndCompaison()   {
            int int1 = 128;
            int int2 = 128;

            System.out.println("int1 == int2 : " + (int1 == int2));

            System.out.println("65 == 'A' : " + (65 == 'A'));


            Integer i  = 128;
            Integer i2 = 128;
            System.out.println("i == i2 : " + (i == i2));

            Integer i3 = 127;
            Integer i4 = 127;
            System.out.println("i3 == i4 : " + (i3 == i4));


            System.out.println("i equals i2 : " + (i.equals(i2)));

            int[] arr1 = {1,2,3,4,5};
            int[] arr2 = {1,2,3,4,5};
            System.out.println("arr1 == arr2 : " + (arr1 == arr2));
            System.out.println("arr1 equals arr2 : " + (arr1.equals(arr2)));
            System.out.println("Arrays.equals(arr1, arr2) : " + (Arrays.equals(arr1, arr2)));

            arr1 = arr2;
            System.out.println("arr1 == arr2 : " + (arr1 == arr2));


        }
    public static void demoSysteme() {
        System.out.println("********** Systeme **********");
        String nom;
        System.out.println("Quel est votre nom ?");
        Scanner sc = new Scanner(System.in);
        nom = sc.next();
        System.out.println("Je m'appelle = " + nom);

    }

    }

