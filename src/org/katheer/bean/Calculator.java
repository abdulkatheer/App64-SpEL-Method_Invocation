package org.katheer.bean;

public class Calculator {
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int sub(int num1, int num2) {
        return num1 - num2;
    }

    public static int mul(int num1, int num2) {
        return num1 * num2;
    }

    public static int div(int num1, int num2) {
        return num1 / num2;
    }

    public static int mod(int num1, int num2) {
        return num1 % num2;
    }

    public static int pow(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    public static int sqrt(int num) {
        return (int) Math.sqrt(num);
    }
}
