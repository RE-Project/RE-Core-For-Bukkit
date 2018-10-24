package fr.reproject.relib.loader;

import javax.annotation.Nonnull;

public class SubPluginLoader {

    private static SubPluginLoader subPluginLoader = new SubPluginLoader();
    private StringBuffer pluginName = new StringBuffer();
    private StringBuffer pluginDescription = new StringBuffer();
    private StringBuffer pluginAuthor = new StringBuffer();
    private StringBuffer pluginVersion = new StringBuffer();

    public void setSubPlugin(@Nonnull String name, String desc, String author, String version) {
        pluginName.append(name);
        pluginName.append(",.,");
        if (desc != null) {
            this.pluginDescription.append(desc);
            this.pluginDescription.append(",.,");
        } else {
            this.pluginDescription.append("description is missing ,.,");
        }
        if (author != null) {
            this.pluginAuthor.append(author);
            this.pluginAuthor.append(",.,");
        } else {
            this.pluginAuthor.append("author is missing ,.,");
        }
        if (version != null) {
            this.pluginVersion.append(version);
            this.pluginVersion.append(",.,");
        } else {
            this.pluginVersion.append("version is missing ,.,");
        }
    }

    public String[] getSubPlugin() {
        String tmp = pluginName.toString();
        return tmp.split(",.,");
    }

    public String[] getSubPluginDesc() {
        String tmp = pluginDescription.toString();
        return tmp.split(",.,");
    }

    public String[] getSubPluginAuthor() {
        String tmp = pluginAuthor.toString();
        return tmp.split(",.,");
    }

    public String[] getSubPluginVersion() {
        String tmp = pluginVersion.toString();
        return tmp.split(",.,");
    }


    public static SubPluginLoader getInstance() {
        return subPluginLoader;
    }

    public boolean getPluginPresence(String name) {
        String tmp = pluginName.toString();
        return tmp.contains(name);
    }
}
