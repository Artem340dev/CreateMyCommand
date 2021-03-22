package ru.pipl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.pipl.utils.CommandData;
import ru.pipl.utils.CommandInterface;
import ru.pipl.utils.Utils;

public class CommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (CommandData.getData(cmd.getName()) != null) {
            CommandInterface command = CommandData.getData(cmd.getName());
            sender.sendMessage(Utils.parseColor(command.getAnswer()));
        }
        return false;
    }
}
