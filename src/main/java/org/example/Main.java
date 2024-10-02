package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задания (1-5):");
        int taskNumber = scanner.nextInt();

        switch (taskNumber) {
            case 1:
                сollections1();
                break;
            case 2:
                primesGenerator2();
                break;
            default:
                System.out.println("Неверный номер задания.");
        }

        scanner.close();
    }

    private static void сollections1() {
        int[] array = MyCollections.createRandomArray(10);
        System.out.println("Случайный массив: " + Arrays.toString(array));
        List<Integer> list = MyCollections.arrayToList(array);
        System.out.println("Список из массива: " + list);
        MyCollections.sortListAscending(list);
        System.out.println("Отсортированный список (по возрастанию): " + list);
        MyCollections.sortListDescending(list);
        System.out.println("Отсортированный список (по убыванию): " + list);
        MyCollections.shuffleList(list);
        System.out.println("Перемешанный список: " + list);
        MyCollections.rotateList(list);
        System.out.println("Список после циклического сдвига: " + list);
        List<Integer> unique = MyCollections.uniqueElements(list);
        System.out.println("Уникальные элементы: " + unique);
        List<Integer> duplicates = MyCollections.duplicateElements(list);
        System.out.println("Дублирующиеся элементы: " + duplicates);
        int[] arrayFromList = MyCollections.listToArray(list);
        System.out.println("Массив из списка: " + Arrays.toString(arrayFromList));
        MyCollections.countOccurrences(arrayFromList);
    }

    private static void primesGenerator2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество простых чисел для генерации:");
        int n = scanner.nextInt();
        PrimesGenerator primesGenerator = new PrimesGenerator(n);

        System.out.println("Простые числа в прямом порядке:");
        for (int prime : primesGenerator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        System.out.println("Простые числа в обратном порядке:");
        Iterator<Integer> reverseIterator = primesGenerator.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();
    }
}
