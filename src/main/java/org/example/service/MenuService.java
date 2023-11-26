package org.example.service;

import org.example.enums.Commands;
import org.example.enums.MenuMessages;
import org.example.model.Animal;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuService {

    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printInfo() {

        System.out.println("____________________________________________" +
                "\n| To add pet, enter " + Commands.ADD +
                "\n| To show all pets, enter " + Commands.SHOW_ALL +
                "\n| To take pet from shelter, enter " + Commands.TAKE +
                "\n| To exit, please enter " + Commands.EXIT +
                "\n| To print this info again, enter " + Commands.INFO +
                "\n____________________________________________");
    }

    public Animal add() {
        Animal.AnimalBuilder builder = Animal.builder();
        try {
            System.out.println(MenuMessages.ENTER_NAME);
            builder.name(scanner.next());
            System.out.println(MenuMessages.ENTER_BREED);
            builder.breed(scanner.next());
            System.out.println(MenuMessages.ENTER_AGE);
            builder.age(scanner.nextInt());
            return builder.build();
        } catch (InputMismatchException e) {
            System.out.println(MenuMessages.NOT_NUMBER);
            return null;
        }
    }

    public String takeName() {
        System.out.println(MenuMessages.ENTER_NAME);
        String name = scanner.next();
        return name;
    }

    public void printNext(){
        System.out.println(MenuMessages.NEXT);
    }
}
