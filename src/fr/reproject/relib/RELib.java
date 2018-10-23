package fr.reproject.relib;

import fr.reproject.relib.init.CommandLoader;
import fr.reproject.relib.loader.SubPluginLoader;
import fr.reproject.relib.utils.Reference;
import org.bukkit.plugin.java.JavaPlugin;

public class RELib extends JavaPlugin {

    private CommandLoader commandloader = new CommandLoader();
    private Reference reference = new Reference();

    @Override
    public void onEnable() {
        SubPluginLoader.getInstance().setSubPlugin(reference.NAME, null, reference.AUTHOR, reference.VERSION);
        SubPluginLoader.getInstance().setSubPlugin("test1", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test2", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test3", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test4", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test5", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test6", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test7", null, null, null);
        SubPluginLoader.getInstance().setSubPlugin("test8", null, null, null);

        commandloader.loadAdminCommand(this);
        System.out.println("RE-Lib: the plugin are on.");
    }

    @Override
    public void onDisable() {
        System.out.println("RE-Lib: the plugin are off.");
    }

    public Reference getReference() {
        return reference;
    }
}
