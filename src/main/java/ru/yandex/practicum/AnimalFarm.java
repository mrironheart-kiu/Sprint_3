package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class AnimalFarm {

    private final ArrayList<String> farmAnimals;

    public AnimalFarm(ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    /**
     * Задание №1
     * На основе списка farmAnimals метод формирует hash-таблицу, где
     * ключ = Animal (тип животного)
     * значение = кол-ву повторений Animal в списке (обще кол-во животных конкретного типа)
     * @return hash-таблица countedAnimals
     */
    public HashMap<Animal, Integer> countedAnimals() {
        checkAnimalTypes();

        HashMap<Animal, Integer> countedAnimals = new HashMap<>();

        for (String farmAnimal : farmAnimals) {
            Animal animal = Animal.valueOf(farmAnimal.split(" ")[0].toUpperCase());
            if (!countedAnimals.containsKey(animal)) {
                countedAnimals.put(animal, 1);
            } else {
                Integer newAmount = countedAnimals.get(animal) + 1;
                countedAnimals.put(animal, newAmount);
            }
        }
        return countedAnimals;
    }

    /**
     * Задание №2
     * Метод возвращает коллекцию всех уникальных имён животных на ферме.
     * Если имя не найдено, то выводится сообщение об ошибке.
     * @return Set<String> uniqueNames
     */
    public Set<String> uniqueNames() {
        Set<String> uniqueNames = new LinkedHashSet<>();

        for (String animal : farmAnimals) {
            try {
                uniqueNames.add(animal.split(" ")[1]);
            } catch (Exception e) {
                System.out.println("Please correct string [" + animal + "]. Incorrect input data.");
            }
        }
        return uniqueNames;
    }

    /**
     * Задание №3
     * Метод добавляет в коллекцию животное по типу животного и имени.
     */
    public void addAnimal(Animal animalType, String name){
        farmAnimals.add(animalType.name() + " " + name);
    }

    /**
     * Задание №3
     * Метод добавляет в коллекцию животное по типу животного.
     */
    public void addAnimal(Animal animal){
        farmAnimals.add(animal.name() + " N");
    }
    /**
     * Задание №3
     * Метод добавляет в коллекцию животное по имени.
     */
    public void addAnimal(String name){
        farmAnimals.add(Animal.NOT_DEFINED + " " + name);
    }

    /**
     * Задание №4
     * Переопределённый метод toString() для вывода списка жифотных в формате таблицы
     */
    @Override
    public String toString() {
        return farmAnimals.toString()
                .replaceAll("[\\[\\]]","")
                .replace(", ", "\n");
    }

    /**
     * Вспомогательный метод.
     * Метод проверяет список farmAnimals на наличие типов животных, не входящих ENUM Animal.
     * Если подобная запись найдена, то выводится сообщение об ошибке и записи удаляются из списка.
     */
    public void checkAnimalTypes(){
        ArrayList<Integer> indexes = new ArrayList<>();

        for (String farmAnimal : this.farmAnimals) {
            try {
                Animal.valueOf(farmAnimal.split(" ")[0].toUpperCase());
            } catch (Exception e) {
                System.out.println("Please correct string [" + farmAnimal + "]. Incorrect input data.");
                indexes.add(0,this.farmAnimals.indexOf(farmAnimal));
            }
        }
        for (int index : indexes) {
            this.farmAnimals.remove(index);
        }
    }
}
