package org.example;

import org.example.enums.Commands;
import org.example.enums.MenuMessages;
import org.example.service.MenuService;
import org.example.service.AnimalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        MenuService menuService = new MenuService(scanner);
        menuService.printInfo();
        AnimalService animalService = new AnimalService(menuService);

        String command;
        do {
            command = scanner.next().toLowerCase();
            executeCommand(animalService, command, menuService);
        } while (!Commands.EXIT.getCommand().toLowerCase().equals(command));

        scanner.close();
    }

    private static void executeCommand(AnimalService animalService, String command, MenuService menuService) {
        if (command.equals(Commands.INFO.getCommand())) {
            animalService.printMenuInfo();
        } else if (command.equals(Commands.ADD.getCommand())) {
            animalService.add();
        } else if (command.equals(Commands.SAVE.getCommand())) {
            animalService.save();
        } else if (command.equals(Commands.TAKE.getCommand())) {
            animalService.take();
        } else if (command.equals(Commands.SHOW_ALL.getCommand())) {
            animalService.showAll();
        } else if (command.equals(Commands.EXIT.getCommand())) {
            animalService.exit();
        } else System.out.println(MenuMessages.INCORRECT_COMMAND);

        if(!(command.equals(Commands.EXIT.getCommand()) || command.equals(Commands.INFO.getCommand())))
            menuService.printNext();
    }
}