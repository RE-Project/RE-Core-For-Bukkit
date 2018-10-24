package fr.reproject.relib.utils;

import fr.reproject.relib.loader.SubPluginLoader;

public class PluginLogger {

    private String name;
    private Reference reference = new Reference();
    private boolean acces;

    public void loadPluginLogger(String plName) {
        if (SubPluginLoader.getInstance().getPluginPresence(plName)) {
            this.name = plName;
            this.acces = true;
        } else {
            System.out.println("\u00A74[ERROR]" + reference.NAME + " : " + "the plugin " + plName + " are not load in the SubPluginLoader.");
            System.out.println("\u00A74[ERROR]" + reference.NAME + " : the plugin can't acces to this function.");
            this.name = plName;
            this.acces = false;
        }
    }

    public void info(String msg) {
        if (this.acces){
            System.out.println("[info]" + this.name + msg);
        } else {
            System.out.println("\u00A74[ERROR]" + reference.NAME + " : " + "the plugin " + this.name + " are not load in the SubPluginLoader.");
            System.out.println("\u00A74[ERROR]" + reference.NAME + " : the plugin can't acces to this function.");
        }
    }
}
