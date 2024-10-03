package org.example;

import java.util.*;
import static org.example.WordFrequencyCounter.countWordFrequencies;

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
            case 3:
                human3();
                break;
            case 4:
                wordFrequency4();
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
        scanner.close();
    }

    private static void human3() {
        // Создаем список объектов Human
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иван", "Сусанин", 25));
        humans.add(new Human("Старуха", "Шапокляк", 30));
        humans.add(new Human("Джесси", "Пинкман", 22));
        humans.add(new Human("Крутой", "Перец", 28));

        // a) Создаем HashSet и добавляем в него список
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet:");
        System.out.println(hashSet);

        // b) Создаем LinkedHashSet и добавляем в него список
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet:");
        System.out.println(linkedHashSet);

        // c) Создаем TreeSet и добавляем в него список
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet:");
        System.out.println(treeSet);

        // d) Создаем TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet с компаратором по фамилии:");
        System.out.println(treeSetByLastName);

        // e) Создаем TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту:");
        System.out.println(treeSetByAge);
    }
    /*
     a) HashSet не сохраняет порядок добавления элементов и не допускает дубликатов.
     b) LinkedHashSet сохраняет порядок добавления элементов и не допускает дубликатов.
     c) TreeSet сортирует элементы по естественному порядку (в данном случае по фамилии и имени) и не допускает дубликатов.
     d) TreeSet с компаратором по фамилии сортирует элементы только по фамилии, игнорируя имя.
     e) TreeSet с анонимным компаратором по возрасту сортирует элементы по возрасту.

     Разные типы сетов ведут себя по-разному из-за разных стратегий хранения и сортировки.
     HashSet использует хеширование, LinkedHashSet использует связный список для сохранения порядка,
     а TreeSet использует красно-черное дерево для сортировки.
     */
    private static void wordFrequency4() {
        String text = "Hello world! Hello everyone. This is a test. Hello world!";
        Map<String, Integer> frequencies = countWordFrequencies(text);

        // Выводим результаты
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
