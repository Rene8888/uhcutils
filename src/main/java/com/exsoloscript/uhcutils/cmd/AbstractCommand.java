package com.exsoloscript.uhcutils.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractCommand implements CommandExecutor {

	private JavaPlugin jp;

	public AbstractCommand(JavaPlugin jp, String... commands) {
		this.jp = jp;
		for (String command : commands) {
			this.jp.getCommand(command).setExecutor(this);
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}

}
