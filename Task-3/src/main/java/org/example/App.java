package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Основной класс приложения
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задание 1 Массив
        int[] array = new int[20];
        fillArrayWithRandomNumbers(array, -10, 10);
        System.out.println("Исходный массив: ");
        printArray(array);

        swapMaxNegativeAndMinPositive(array);

        System.out.println("Массив после замены: ");
        printArray(array);

        // Задание 2 Сладкий подарок
        System.out.println("Соберем сладкий подарок!");
        List<Sweet> sweets = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            System.out.print("Введите название сладости: ");
            String name = scanner.nextLine();

            System.out.print("Введите вес сладости (граммы): ");
            double weight = scanner.nextDouble();

            System.out.print("Введите цену сладости: ");
            double price = scanner.nextDouble();

            System.out.print("Введите уникальный параметр сладости: ");
            String uniqueParameter = scanner.next();

            sweets.add(new Sweet(name, weight, price, uniqueParameter));

            System.out.print("Хотите добавить еще одну сладость? (да/нет): ");
            String response = scanner.next();
            addMore = response.equalsIgnoreCase("да");
            scanner.nextLine();
        }

        SweetGift sweetGift = new SweetGift(sweets);
        System.out.println("Информация о сладком подарке:");
        System.out.println(sweetGift);

        scanner.close();
    }

    // Метод для заполнения массива случайными
    private static void fillArrayWithRandomNumbers(int[] array, int min, int max) {

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
    }

    // Метод для нахождения и замены отрицательного и положительного элементов
    private static void swapMaxNegativeAndMinPositive(int[] array) {
        int maxNegativeIndex = -1;
        int minPositiveIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && (maxNegativeIndex == -1 || array[i] > array[maxNegativeIndex])) {
                maxNegativeIndex = i;
            }
            if (array[i] > 0 && (minPositiveIndex == -1 || array[i] < array[minPositiveIndex])) {
                minPositiveIndex = i;
            }
        }
        // Меняем местами
        if (maxNegativeIndex != -1 && minPositiveIndex != -1) {

            int temp = array[maxNegativeIndex];
            array[maxNegativeIndex] = array[minPositiveIndex];
            array[minPositiveIndex] = temp;
            System.out.printf("Поменяли { %d (макс. отриц.) } и { %d (мин. полож.) } местами%n",
                    array[minPositiveIndex], array[maxNegativeIndex]);
        } else {
            System.out.println("Не удалось найти подходящие элементы для замены");
        }
    }

    // Ме од для печати массива
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Sweet {
    private String name; // наименование
    private double weight; // вес
    private double price;  // цена
    private String uniqueParameter; // уникальный параметр

    public Sweet(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Сладость: %s, Вес: %.2f г, Цена: %.2f, Уникальный параметр: %s",
                name, weight, price, uniqueParameter);
    }
}

class SweetGift {
    private List<Sweet> sweets;

    public SweetGift(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sweet sweet : sweets) {
            result.append(sweet.toString()).append("\n");
        }
        result.append(String.format("Общий вес подарка: %.2f г%n", getTotalWeight()));
        result.append(String.format("Общая стоимость подарка: %.2f%n", getTotalPrice()));
        return result.toString();
    }
}