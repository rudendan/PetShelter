package org.example.enums;

public enum MenuMessages {
    EMPTY("Shelter is empty"),
    INCORRECT_COMMAND("You entered incorrect command. Please try again..."),
    SAVED("Changes were saved"),
    ERROR("Something wrong... Try again"),
    ENTER_NAME("Please enter the name of the pet:"),
    ENTER_BREED("Please enter breed the of the pet: "),
    ENTER_AGE("Please enter age the of the pet: "),
    SHELTER_ANIMALS("Animals in the shelter: "),
    ANIMAL_ADDED("This animal was added"),
    ANIMAL_TAKEN(" have been taken from shelter"),
    ANIMAL_NOT_EXIST("There is no animal in shelter with name "),
    EXIT("Goodbye. See you soon!"),
    NEXT("Please enter next command (enter \"info\" to see legend)"),
    NOT_NUMBER("You try to input not number value in age");

    private String message;

    MenuMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
