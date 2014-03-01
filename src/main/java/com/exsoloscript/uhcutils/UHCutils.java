package com.exsoloscript.uhcutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.exsoloscript.uhcutils.cmd.JoinCommands;
import com.exsoloscript.uhcutils.event.LoginListener;

public class UHCutils extends JavaPlugin {
	
	public static int maxPlayers = 0;
	
	public void onEnable() {
		loadConfig();
		registerEvents();
		registerCommands();
		
		int pl = this.getConfig().getInt("config.max-players");
		maxPlayers = pl;
	}
	
	public void onDisable() {
		
	}
	
	private void loadConfig() {
		this.getConfig().addDefault("config.max-players", 30);
	}
	
	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new LoginListener(), this);
	}
	
	private void registerCommands() {
		getCommand("canjoin").setExecutor(new JoinCommands(this));
	}

	public static int playersCanJoin() {
		int mortals = 0;
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!p.isOp()) mortals++;
		}
		return mortals;
	}
	
	public static String prefix() {
		return ChatColor.AQUA + "[UHCu] " + ChatColor.GOLD;
	}
	
}
