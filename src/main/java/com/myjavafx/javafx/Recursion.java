package com.myjavafx.javafx;

import java.util.Scanner;

public class Recursion {
    /** Main Method */
    public static void main(String[] args) {
        //Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Enter two integers to compute the greatest common divisor: \n");

        System.out.print("Integer #1: ");
        int oneInt = input.nextInt();

        System.out.print("Integer #2: ");
        int twoInt = input.nextInt();

        //Display the Greatest Common Divisor
        System.out.println("\nThe greatest common divisor of "
                + oneInt + " and " + twoInt + " is: " + GCD(oneInt,twoInt));

    }

    /** Return the GCD for the two integers */
    public static long GCD(long oneInt, long twoInt) {
        if (oneInt % twoInt == 0) {
            return twoInt;
        }
        else
            return GCD(twoInt, oneInt % twoInt);
    }
}

/** If m % n is 0, gcd(m, n) is n.
 - Otherwise, gcd(m, n) is gcd(n, m % n).
 Write a recursive method to find the GCD. Write a test program that prompts the
 user to enter two integers and displays their GCD.
 Sample Run
 Enter the first number: 3
 Enter the second number: 7
 The GCD of 3 and 7 is 1
*/