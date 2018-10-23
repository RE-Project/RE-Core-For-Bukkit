package fr.reproject.relib.init;

import fr.reproject.relib.RELib;
import fr.reproject.relib.command.CommandVersion;

public class CommandLoader {

    public void loadAdminCommand(RELib intance) {
        intance.getCommand("reversion").setExecutor(new CommandVersion(intance));

    }
}
