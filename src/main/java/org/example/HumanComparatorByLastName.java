package org.example;

import java.util.Comparator;

// Компаратор для сравнения людей по фамилии
public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}
