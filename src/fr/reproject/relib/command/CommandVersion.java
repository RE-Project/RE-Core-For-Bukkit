package fr.reproject.relib.command;

import fr.reproject.relib.RELib;
import fr.reproject.relib.loader.SubPluginLoader;
import fr.reproject.relib.utils.Reference;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandVersion implements CommandExecutor {

    private Reference reference;

    public CommandVersion(RELib reLib) {
        this.reference = reLib.getReference();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("\u00A7a+\u00A72-------\u00A7b" + reference.NAME + "\u00A72-------\u00A7a+");
            sender.sendMessage("\u00A72  +Plugin Version : \u00A7b" + reference.VERSION);
            sender.sendMessage("\u00A72  +Plugin by: \u00A7b" + reference.AUTHOR);
            sender.sendMessage("\u00A72  +Plugin Load in \u00A73" + reference.NAME + "\u00A72 :");
            listSubPlugins(sender);
            sender.sendMessage("\u00A7a+\u00A72-------\u00A7b" + reference.NAME + "\u00A72-------\u00A7a+");
        } else if (args[0] == "subplugin") {
            sender.sendMessage("\u00A7a+\u00A72-------\u00A7b" + reference.NAME + "\u00A72-------\u00A7a+");
            listAllSubPlugins(sender);
            sender.sendMessage("\u00A7a+\u00A72-------\u00A7b" + reference.NAME + "\u00A72-------\u00A7a+");
        }
        return false;
    }

    private void listSubPlugins(CommandSender sender) {
        String[] pluginsList = SubPluginLoader.getInstance().getSubPlugin();
        String list = "";
        for(int i = 1; i <= pluginsList.length; i++) {
            list+=pluginsList[i-1] + " ";
            if(i % 2 == 0) {
                sender.sendMessage("\u00A7b" + list);
                list = "";
            }
        }
        sender.sendMessage("\u00A7b" + list);
    }

    private void listAllSubPlugins(CommandSender sender) {
        String[] pluginsName = SubPluginLoader.getInstance().getSubPlugin();
        String[] pluginsDesc = SubPluginLoader.getInstance().getSubPluginDesc();
        String[] pluginsAuthor = SubPluginLoader.getInstance().getSubPluginAuthor();
        String[] pluginsVersion = SubPluginLoader.getInstance().getSubPluginVersion();
        for (int i = 0; i < pluginsName.length; i++) {
            sender.sendMessage("\u00A72  +Plugin Name : \u00A7b" + pluginsName[i]);
            sender.sendMessage("\u00A72    -\u00A73Author : \u00A79" + pluginsAuthor[i]);
            sender.sendMessage("\u00A72    -\u00A73Version : \u00A79" + pluginsVersion[i]);
            sender.sendMessage("\u00A72    -\u00A73Desc : \u00A79" + pluginsDesc[i]);
        }
    }

}
