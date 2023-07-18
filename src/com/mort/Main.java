package com.mort;
import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;


        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        while (true) {


            System.out.printf("Principal");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a value between 1000 and 1_000_000");
        }

        float monthlyInterest = 0;
        while (true) {

            System.out.print("Annual Interest Rate:");
            float annualInterset = scanner.nextFloat();
            if (annualInterset >= 1 && annualInterset <= 30) {
                monthlyInterest = annualInterset / PERCENT / MONTH_IN_YEAR;
                break;
            }

            System.out.println("Enter a value between 1 and 30");
        }

        int numberOfPayments = 0;
        while (true) {
            System.out.print("Period (Years):");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);


    }
    }
