package ru.dataart.academy.java;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Calculator get number of 1: " +
                calculator.getNumberOfChar("test.zip", '1'));

        System.out.println("Calculator get max length: " +
                calculator.getMaxWordLength("test1.zip"));
    }
}