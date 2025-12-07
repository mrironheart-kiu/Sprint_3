package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.Arrays;

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

        System.out.println(farmAnimals.countedAnimals());
        System.out.println(farmAnimals.uniqueNames());
        System.out.println(farmAnimals);
    }
}
