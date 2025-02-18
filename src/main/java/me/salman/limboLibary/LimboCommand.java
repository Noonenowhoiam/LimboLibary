package me.salman.limboLibary;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LimboCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0 && args[0].equalsIgnoreCase("return")) {
                VoidWorldManager.sendToNormalWorld(player);
                player.sendMessage("§aYou have been sent back to the normal world.");
            } else {
                VoidWorldManager.sendToLimbo(player);
                VoidWorldManager.setSendTitle(true);
                VoidWorldManager.setSendActionBar(true);
                VoidWorldManager.setTitleText("&aWelCome to Limbo", "&aTnxt For using LimboApi");
                VoidWorldManager.setActionBarText("&aTnx for using LimboApi");
                player.sendMessage("§cYou have been sent to the limbo world.");
            }

            return true;
        }

        sender.sendMessage("§cThis command can only be used by a player.");
        return false;
    }
}
