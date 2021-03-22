package ru.pipl.utils;

import java.util.ArrayList;
import java.util.List;

public class CommandData implements CommandInterface {
    public static List<CommandInterface> data = new ArrayList<>();

    public static CommandInterface getData(String command) {
        for (CommandInterface cmd : data) {
            if (cmd.getCommand().equals(command)) return cmd;
        }
        return null;
    }

    private String command, answer;

    public CommandData(String command, String answer) {
        this.command = command;
        this.answer = answer;
        data.add(this);
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}