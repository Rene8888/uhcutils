package com.exsoloscript.uhcutils.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class PlayerListener {
	
	@EventHandler
	public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
		if (event.getEntityType() == EntityType.PLAYER) {
			if (event.getRegainReason() == RegainReason.SATIATED) event.setCancelled(true);
		}
	}
}
