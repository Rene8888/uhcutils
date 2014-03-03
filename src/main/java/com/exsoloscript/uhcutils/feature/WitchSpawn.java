package com.exsoloscript.uhcutils.feature;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class WitchSpawn extends Feature {

	public WitchSpawn(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("WitchSpawn");
		this.setDescription("Allows natural witch spawns");
	}

	public void enable() {}

	public void disable() {}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (!isEnabled()) {
			if (event.getSpawnReason() == SpawnReason.NATURAL) {
				if (event.getEntityType() == EntityType.WITCH) {
					event.setCancelled(true);
				}
			}
		}
	}
}
