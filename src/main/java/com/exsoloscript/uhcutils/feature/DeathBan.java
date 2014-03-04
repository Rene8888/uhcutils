package com.exsoloscript.uhcutils.feature;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.exsoloscript.player.UHCPlayer;
import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.timer.DeathBanTimer;

public class DeathBan extends Feature {

	private int timeUntilBan = 30;

	public DeathBan(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("DeathBan");
		this.setDescription("Bans a player after death after a specified amount of time");
		this.timeUntilBan = UHCutils.getMainConfig().getInt("feature.death-ban.time-until-ban");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerDeath(PlayerDeathEvent event) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(UHCutils.getPlugin(), new DeathBanTimer(new UHCPlayer(event.getEntity()), timeUntilBan), 0L, 20L);
	}
}
