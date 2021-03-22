package ru.pipl.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CommandRegister extends Command implements PluginIdentifiableCommand {
    protected Plugin plugin;
    protected final CommandExecutor executor;

    protected CommandRegister(Plugin plugin, String description, String usage, List<String> aliases, CommandExecutor executor) {
        super(aliases.get(0), description, usage, aliases);
        this.executor = executor;
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return this.executor.onCommand(sender, this, label, args);
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    public static void register(Plugin plugin, CommandExecutor executor, String[] aliases, String description, String usage) {
        try {
            CommandRegister register = new CommandRegister(plugin, description, usage, Arrays.asList(aliases), executor);
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            CommandMap map = (CommandMap) field.get(Bukkit.getServer());
            map.register(plugin.getDescription().getName(), register);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}