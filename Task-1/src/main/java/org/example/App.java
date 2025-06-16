package org.example;

import java.util.Scanner;

/**
 * Класс `App` реализует сложение дробных чисел, введенных через консоль
 */
public class App {

    /**
     * Метод `main` - точка входа в программу
     * @param args Массив строковых аргументов командной строки (не используется)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую дробь через пробел (числитель знаменатель):");
        int num1 = scanner.nextInt();
        int den1 = scanner.nextInt();

        System.out.println("Введите вторую дробь через пробел (числитель знаменатель):");
        int num2 = scanner.nextInt();
        int den2 = scanner.nextInt();

        scanner.close();
        // Считаем сумму дробей
        double sum = addFractions(num1, den1, num2, den2);

        // Форматируем результат до 4 знаков после запятой
        System.out.printf("Сумма дробей: %.4f%n", sum);

    }


    /**
     * Метод `addFractions` выполняет сложение двух дробей
     * @param num1 Числитель первой дроби
     * @param den1 Знаменатель первой дроби
     * @param num2 Числитель второй дроби
     * @param den2 Знаменатель второй дроби
     * @return Сумма двух дробей в виде числа с плавающей точкой
     */
    public static double addFractions(int num1, int den1, int num2, int den2) {
        // Приводим дроби к общему
        int commonDenominator = den1 * den2;
        int newNum1 = num1 * den2;
        int newNum2 = num2 * den1;

        // Складываем числители
        int sumNum = newNum1 + newNum2;

        // Возвращаем результат
        return (double) sumNum / commonDenominator;
    }
}