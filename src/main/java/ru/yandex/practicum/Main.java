package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> animals =  new ArrayList<>(
                Arrays.asList(
                        "DOG Жучка",
                        "DOG Шарик",
                        "CAT Пушок",
                        "HORSE Тыблычко",
                        "dog Шарик",
                        "HORSE Молочко",
                        "COW Муська",
                        "COW Дуська",
                        "COW Пуська",
                        "HORSE",
                        "CAT  ",
                        "неверная строка",
                        "кривая строка"
                )
        );

        AnimalFarm farmAnimals = new AnimalFarm(animals);
        farmAnimals.addAnimal(Animal.CAT, "Васька");
        farmAnimals.addAnimal(Animal.COW);
        farmAnimals.addAnimal("Петрович");

        HashMap<Animal, Integer> countedAnimals = farmAnimals.countedAnimals();
        Set<String> uniqueNames = farmAnimals.uniqueNames();

        System.out.println(countedAnimals);
        System.out.println(uniqueNames);
        System.out.println(farmAnimals);

    }
}
