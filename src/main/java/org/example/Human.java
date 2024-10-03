package org.example;

// Класс, представляющий человека с именем, фамилией и возрастом.
public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    // Конструктор
    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName); // Сравниваем по фамилии
    }

    @Override
    public String toString() {
        return String.format("Human{firstName='%s', lastName='%s', age=%d}", firstName, lastName, age);
    }
}
