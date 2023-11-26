package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.enums.MenuMessages;
import org.example.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private List<Animal> animals = new ArrayList<>();
    private final File storage = new File("src/main/resources/shelter.json");
    private final ObjectMapper mapper = new JsonMapper();
    private MenuService menuService;

    public AnimalService() {}
    public AnimalService(MenuService menuService) {
        this.menuService = menuService;
        CollectionType animalsType = mapper.getTypeFactory().constructCollectionType(List.class, Animal.class);
        mapper.registerModule(new JavaTimeModule());

        try {
            if (!storage.exists()) {
                storage.createNewFile();
            } else {
                this.animals = mapper.readValue(storage, animalsType);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printMenuInfo() {
        menuService.printInfo();
    }

    public void add() {
        Animal animal = menuService.add();
        if(animal != null) {
            animals.add(animal);
            System.out.println(MenuMessages.ANIMAL_ADDED);
        }
    }

    public void take() {

        boolean isExist = false;
        String name = menuService.takeName();
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                isExist = true;
                animals.remove(animal);
                System.out.println(animal.getName() + MenuMessages.ANIMAL_TAKEN);
                break;
            }
        }
        if (!isExist) System.out.println(MenuMessages.ANIMAL_NOT_EXIST + name);
    }

    public void showAll() {
        if (animals.isEmpty()) System.out.println(MenuMessages.EMPTY);
        else {
            System.out.println(MenuMessages.SHELTER_ANIMALS);
            animals.forEach(System.out::println);
        }
    }

    public void exit() {
        save();
        System.out.println(MenuMessages.EXIT);
    }

    public void save() {
        try {
            mapper.writeValue(storage, animals);
            System.out.println(MenuMessages.SAVED);
        } catch (IOException e) {
            System.err.println(MenuMessages.ERROR);
        }
    }
}
