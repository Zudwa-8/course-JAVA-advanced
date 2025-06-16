package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String[] args) {
        String filePath = "input.txt"; // ПУть к файлу(с таким путём файл должен лежатьв папке Task-5)
        Map<String, Integer> wordCount = new HashMap<>();

        // Чтение слов из файла
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+"); // Разделение строки по пробелам
                for (String word : words) {
                    word = word.toLowerCase(); // Приведение к нижнему регистру для учета регистра
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        // Сортировка слов в алфавитном порядке
        List<String> sortedWords = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedWords);

        // Вывод статистики
        System.out.println("Статистика слов:");
        for (String word : sortedWords) {
            System.out.printf("%s - %d раз(а)%n", word, wordCount.get(word));
        }

        // Поиск слова с максимальным количеством повторений
        String maxWord = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        // Вывод слова с максимальным количеством повторений
        if (maxWord != null) {
            System.out.printf("Слово с максимальным количеством повторений: \"%s\" - %d раз(а)%n", maxWord, maxCount);
        }

        //
    }
}