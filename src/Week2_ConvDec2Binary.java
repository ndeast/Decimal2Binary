/*
* Nik Eastburn
* CSC242-01
* Week 2
* This program converts decimal numbers to binary
*
* */

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Week2_ConvDec2Binary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input;
        Stack<Integer> binaryResult;
        boolean good = false;

        System.out.println("Welcome. This program will convert Decimal to Binary!\n");

        // Loop until valid input is detected.
        do {
            System.out.println("Please enter a number between 0 and 2,000,000: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                // ensure input is between 0 and 2 Million
                if (input >= 0 && input <= 2000000) {
                    good = true;
                    convertDecimalToBinary(input);
                } else {
                    System.out.println("Integer was out of bounds.\n");
                }
            } else {
                System.out.println("Please enter a valid number.\n");
                scanner.nextLine();
            }

        } while (!good);

    }

    public static void convertDecimalToBinary(int decimal) {
        int origDecimal = decimal;
        Stack<Integer> binaryResult = new Stack<>();
        // divide the decimal number by 2, and add the modulus
        // to a Stack of Integer, until the decimal equals 0
        do {
            binaryResult.add(decimal % 2);
            decimal = decimal / 2;

        } while (decimal != 0);

        // add 0s to fill in smaller binary numbers to hit 8 bits
        if (binaryResult.size() < 8) {
            while(binaryResult.size() < 8){
                binaryResult.add(0);
            }
        }

        // Reverse the stack since the division method places
        // values in reverse order
        Collections.reverse(binaryResult);

        System.out.println("Decimal: \n" + origDecimal);
        System.out.println("Binary: ");

        // print out the stack of binary values
        for (int dec : binaryResult) {
            System.out.print(dec);
        }
    }
}
