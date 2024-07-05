package com.example;

public class Factorial {
    public long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        Factorial calculator = new Factorial();
        int number = 5;
        long factorial = calculator.factorial(number);
        System.out.println("Факториал числа " + number + " равен " + factorial);
    }
}

