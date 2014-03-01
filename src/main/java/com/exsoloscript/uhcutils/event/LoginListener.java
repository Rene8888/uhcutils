package com.exsoloscript.uhcutils.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.exsoloscript.uhcutils.UHCutils;

public class LoginListener implements Listener {
	
	private String kickMessage;
	
	public LoginListener() {
		this.kickMessage = ChatColor.AQUA + "[UHC] " + ChatColor.WHITE + "- " + ChatColor.DARK_RED + "Server full";
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerLoginFirst(PlayerLoginEvent event) {
		if (Bukkit.getOnlinePlayers().length >= UHCutils.maxPlayers) {
			event.disallow(Result.KICK_FULL, "Server full");
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerLogin(PlayerLoginEvent event) {
		if (event.getResult() == Result.KICK_FULL) {
			if (event.getPlayer().isOp()) event.allow();
			else {
				if (UHCutils.playersCanJoin() < Bukkit.getMaxPlayers()) event.allow();
				else event.setKickMessage(this.kickMessage);
			}
		}
	}
}
