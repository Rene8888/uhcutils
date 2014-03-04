package com.exsoloscript.uhcutils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.exsoloscript.uhcutils.cmd.JoinCommands;
import com.exsoloscript.uhcutils.event.LoginListener;
import com.exsoloscript.uhcutils.player.UHCPlayerManager;
import com.exsoloscript.uhcutils.team.Teams;

public class UHCutils extends JavaPlugin {

	public static int maxPlayers = 0;

	private static UHCutils CURRENT_UHCUTILS_INSTANCE;
	private static UHCPlayerManager UHC_PLAYER_MANAGER;
	private static Teams UHC_TEAMS;

	private static FileConfiguration config;
	private static JavaPlugin plugin;

	public void onEnable() {

		CURRENT_UHCUTILS_INSTANCE = this;
		UHC_PLAYER_MANAGER = new UHCPlayerManager(this);
		UHC_TEAMS = new Teams();

		loadConfig();
		registerEvents();
		registerCommands();

		int pl = this.getConfig().getInt("config.max-players");
		maxPlayers = pl;

		FileConfiguration fc = this.getConfig();
		config = fc;

		JavaPlugin plug = this;
		plugin = plug;
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
		new JoinCommands(this);
	}

	public static String prefix() {
		return ChatColor.AQUA + "[UHCu] " + ChatColor.GOLD;
	}

	public static UHCutils getUHCutils() {
		return CURRENT_UHCUTILS_INSTANCE;
	}

	public static UHCPlayerManager getUHCPlayerManager() {
		return UHC_PLAYER_MANAGER;
	}

	public static Teams getTeams() {
		return UHC_TEAMS;
	}

	public static FileConfiguration getMainConfig() {
		return config;
	}

	public static JavaPlugin getPlugin() {
		return plugin;
	}
}
