package org.example;

import java.util.Scanner;

/**
 * Класс `App` реализует калькулятор и поиск самого длинного слова в массиве
 */
public class App {

    /**
     * Метод `main` - точка входа в программу
     * @param args Массив строковых аргументов командной строки (не используется)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задания: (1 - калькулятор, 2 - поиск максимального слова)");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера ввода

        if (taskNumber == 1) {
            calculator(scanner);
        } else if (taskNumber == 2) {
            findLongestWord(scanner);
        } else {
            System.out.println("Некорректный ввод задания. Выберите 1 или2");
        }

        scanner.close();
    }

    private static void calculator(Scanner scanner) {
        System.out.println("Введите первую дробь через пробел (числитель знаменатель):");
        int num1 = scanner.nextInt();
        int den1 = scanner.nextInt();

        System.out.println("Введите вторую дробь через пробел (числитель знаменатель):");
        int num2 = scanner.nextInt();
        int den2 = scanner.nextInt();

        System.out.println("Выберите операцию (1 - сложение, 2 - вычитание, 3 - умножение, 4 - деление):");
        int operation = scanner.nextInt();
        double result = 0;

        switch (operation) {
            case 1:
                result = addFractions(num1, den1, num2, den2);
                break;
            case 2:
                result = subtractFractions(num1, den1, num2, den2);
                break;
            case 3:
                result = multiplyFractions(num1, den1, num2, den2);
                break;
            case 4:
                result = divideFractions(num1, den1, num2, den2);
                break;
            default:
                System.out.println("Некорректный ввод операции.");
                return;
        }

        System.out.printf("Результат: %.4f%n", result);
    }

    private static void findLongestWord(Scanner scanner) {
        System.out.println("Введите размерность массива:");
        int size = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера ввода

        String[] words = new String[size];
        System.out.println("Введите слова:");

        for (int i = 0; i < size; i++) {
            words[i] = scanner.nextLine();
        }

        String longestWord = findLongest(words);
        System.out.println("Самое длинное слово: " + longestWord);
    }

    private static String findLongest(String[] words) {
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static double addFractions(int num1, int den1, int num2, int den2) {
        int commonDenominator = den1 * den2;
        int newNum1 = num1 * den2;
        int newNum2 = num2 * den1;
        int sumNum = newNum1 + newNum2;
        return (double) sumNum / commonDenominator;
    }

    public static double subtractFractions(int num1, int den1, int num2, int den2) {
        int commonDenominator = den1 * den2;
        int newNum1 = num1 * den2;
        int newNum2 = num2 * den1;
        int diffNum = newNum1 - newNum2;
        return (double) diffNum / commonDenominator;
    }

    public static double multiplyFractions(int num1, int den1, int num2, int den2) {
        int numResult = num1 * num2;
        int denResult = den1 * den2;
        return (double) numResult / denResult;
    }

    public static double divideFractions(int num1, int den1, int num2, int den2) {
        int numResult = num1 * den2;
        int denResult = den1 * num2;
        return (double) numResult / denResult;
    }
}