package org.example.enums;

public enum Commands {

    ADD("add"),
    SHOW_ALL("showAll"),
    TAKE("take"),
    EXIT("exit"),
    INFO("info"),
    SAVE("save");

    String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command.toLowerCase();
    }

    @Override
    public String toString() {
        return "\"" + command + "\"";
    }
}
