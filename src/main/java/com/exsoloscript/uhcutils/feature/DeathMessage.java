package com.exsoloscript.uhcutils.feature;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.exsoloscript.uhcutils.UHCutils;

public class DeathMessage extends Feature {

	public DeathMessage(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("DeathMessage");
		this.setDescription("Adds a prefix and suffix to the player death messages");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (isEnabled())
			if (UHCutils.getMainConfig().getBoolean("features.death-messages.remove")) {
				event.setDeathMessage(null);
			} else {
				String msg = ChatColor.translateAlternateColorCodes('&', UHCutils.getMainConfig().getString("features.death-messages.message"));
				msg = msg.replaceAll("%message", event.getDeathMessage());
				msg = msg.replaceAll("%player", event.getEntity().getName());
				msg = msg.replaceAll("%coords", locationString(event.getEntity().getLocation()));
				event.setDeathMessage(msg);
			}
	}

	private String locationString(Location loc) {
		return "x:" + loc.getBlockX() + " y:" + loc.getBlockY() + " z:" + loc.getBlockZ();
	}
}
