package com.exsoloscript.uhcutils.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.exsoloscript.uhcutils.Game;
import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.Util;
import com.exsoloscript.uhcutils.player.UHCPlayer;

public class LoginListener implements Listener {

	private String kickMessage;

	public LoginListener() {
		this.kickMessage = ChatColor.AQUA + "[UHC] " + ChatColor.WHITE + "- " + ChatColor.DARK_RED + "Server full";
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerLogin(PlayerLoginEvent event) {
		Game game = UHCutils.getGame();
		UHCPlayer player = UHCutils.getUHCPlayerManager().getPlayer(event.getPlayer());
		if (game.isStarted() == false) {
			if (player.isOp()) {
				event.allow();
			} else if (Util.getPlayerCountWithoutOps() < Bukkit.getMaxPlayers()) {
				event.allow();
			} else {
				event.disallow(Result.KICK_FULL, this.kickMessage);
				event.setKickMessage(this.kickMessage);
			}
		} else {
			if (player.isOp()) {
				if (player.isAdminMode()) {
					// TODO hide player and remove chat message
					event.allow();
				} else {
					event.allow();
				}
			} else if (player.isInGame()) {
				event.allow();
			}
		}
	}
}