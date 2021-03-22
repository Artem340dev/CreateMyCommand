package ru.pipl.main;

import org.bukkit.plugin.java.JavaPlugin;
import ru.pipl.commands.CommandListener;
import ru.pipl.commands.CommandRegister;
import ru.pipl.utils.CommandData;

import java.io.File;

public class SpigotPlugin extends JavaPlugin {
    private void loadConfiguration() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    private void loadValues() {
        for (String command : getConfig().getConfigurationSection("commands").getKeys(false)) {
            String answer = getConfig().getString("commands."+command);
            new CommandData(command, answer);
            CommandRegister.register(this, new CommandListener(), new String[] {command}, "/"+command, "/"+command);
        }
    }

    public void onEnable() {
        loadConfiguration();
        loadValues();
    }
}