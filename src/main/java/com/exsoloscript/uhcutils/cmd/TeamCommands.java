package com.exsoloscript.uhcutils.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.exsoloscript.uhcutils.UHCutils;

public class TeamCommands extends AbstractCommand {

	@SuppressWarnings("unused")
	private UHCutils plugin;

	public TeamCommands(UHCutils u) {
		super(u, "");
		this.plugin = u;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
}
