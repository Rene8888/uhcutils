package com.exsoloscript.player;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UHCPlayerManager implements Listener {

	private HashMap<Player, UHCPlayer> map;

	public UHCPlayerManager(JavaPlugin jp) {
		this.map = new HashMap<Player, UHCPlayer>();
		for (Player p : jp.getServer().getOnlinePlayers()) {
			this.addPlayer(p, new UHCPlayer(p));
		}
		jp.getServer().getPluginManager().registerEvents(this, jp);
	}

	public UHCPlayer addPlayer(Player p, UHCPlayer uhcp) {
		return this.map.put(p, uhcp);
	}

	public UHCPlayer removePlayer(Player p) {
		return this.map.remove(p);
	}

	public UHCPlayer getPlayer(Player p) {
		return this.map.get(p);
	}

	public UHCPlayer getPluginPlayer(Player p) {
		return (UHCPlayer) this.map.get(p);
	}

	public int size() {
		return this.map.size();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerLoginEvent e) {
		this.addPlayer(e.getPlayer(), new UHCPlayer(e.getPlayer()));
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerQuit(PlayerQuitEvent e) {
		this.removePlayer(e.getPlayer());
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerKick(PlayerKickEvent e) {
		this.removePlayer(e.getPlayer());
	}

}
