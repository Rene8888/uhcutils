package com.exsoloscript.uhcutils.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.Util;

public class JoinCommands implements CommandExecutor {

	@SuppressWarnings("unused")
	private UHCutils plugin;

	public JoinCommands(UHCutils u) {
		this.plugin = u;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("canjoin")) {
			sender.sendMessage(UHCutils.prefix() + "Currently are " + Bukkit.getOnlinePlayers().length + "/" + Bukkit.getMaxPlayers() + " players online. " + (Bukkit.getMaxPlayers() - Util.getPlayerCountWithoutOps()) + " slots are free!");
			return true;
		}

		return false;
	}

}
