package com.exsoloscript.uhcutils.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.exsoloscript.uhcutils.UHCutils;

public class JoinCommands extends AbstractCommand {

	@SuppressWarnings("unused")
	private UHCutils plugin;

	public JoinCommands(UHCutils u) {
		super(u, "");
		this.plugin = u;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
}
