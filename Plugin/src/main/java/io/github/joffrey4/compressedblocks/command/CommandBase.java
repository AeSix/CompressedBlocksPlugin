package io.github.joffrey4.compressedblocks.command;

import io.github.joffrey4.compressedblocks.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class CommandBase implements CommandExecutor {

    Main plugin;

    public CommandBase(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length > 0 && Objects.equals(strings[0], "give")) {
            if (!commandSender.hasPermission("compressedblocks.command.give")) {
                commandSender.sendMessage("Lack of permission: compressedblocks.command.give");
                return true;
            }
            return new CommandGive(plugin.getConfig(), commandSender, strings).executeCommand();

        } else if (strings.length == 1 && Objects.equals(strings[0], "info")) {
            if (!commandSender.hasPermission("compressedblocks.command.info")) {
                commandSender.sendMessage("Lack of permission: compressedblocks.command.info");
                return true;
            }
            return new CommandInfo(plugin, commandSender).executeCommand();
        }
        return false;
    }
}
