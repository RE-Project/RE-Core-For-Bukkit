package fr.reproject.relib;

import fr.reproject.relib.init.CommandLoader;
import fr.reproject.relib.loader.SubPluginLoader;
import fr.reproject.relib.utils.PluginLogger;
import fr.reproject.relib.utils.Reference;
import org.bukkit.plugin.java.JavaPlugin;

public class RELib extends JavaPlugin {

    private CommandLoader commandloader = new CommandLoader();
    private Reference reference = new Reference();
    private PluginLogger pluginLogger = new PluginLogger();

    @Override
    public void onEnable() {
        SubPluginLoader.getInstance().setSubPlugin(reference.NAME, reference.DESC, reference.AUTHOR, reference.VERSION);
        pluginLogger.loadPluginLogger(reference.NAME);


        commandloader.loadAdminCommand(this);
        pluginLogger.info("the plugin are on.");
    }

    @Override
    public void onDisable() {
        System.out.println("RE-Lib: the plugin are off.");
    }

    public Reference getReference() {
        return reference;
    }
}
