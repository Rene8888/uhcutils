package com.exsoloscript.uhcutils.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.exsoloscript.uhcutils.UHCutils;

public class StartCommands extends AbstractCommand {

	public StartCommands() {
		super(UHCutils.getUHCutils(), "start");
	}

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
