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
			if (command != null && command.equals("") == true) {
				this.jp.getCommand(command).setExecutor(this);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}

}
