package com.exsoloscript.uhcutils.feature;

import org.bukkit.World.Environment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityPortalEvent;

import com.exsoloscript.uhcutils.UHCutils;

public class Nether extends Feature {

	public Nether(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("Nether");
		this.setDescription("Disable the ability to enter the Nether");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onEntityPortal(EntityPortalEvent event) {
		if (event.getTo().getWorld().getEnvironment() == Environment.THE_END)
			event.setCancelled(true);

		if (isEnabled()) {
			if (event.getTo().getWorld().getEnvironment() == Environment.NETHER)
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (UHCutils.getMainConfig().getBoolean("feature.nether.spawn-zombie-pigmen"))
			if (event.getEntityType() == EntityType.PIG_ZOMBIE) {
				if (event.getSpawnReason() == SpawnReason.NATURAL)
					event.setCancelled(true);
			}
	}
}
