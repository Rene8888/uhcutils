package com.exsoloscript.uhcutils.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("start")) {
			if (args.length > 1) {
				
			} else {
				sender.sendMessage(ChatColor.RED + "Correct usage: ");
			}
		}
		
		return false;
	}

}
