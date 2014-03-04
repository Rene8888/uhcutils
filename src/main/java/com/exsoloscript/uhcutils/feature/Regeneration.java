package com.exsoloscript.uhcutils.feature;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class Regeneration extends Feature {

	public Regeneration(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("DisableRegeneration");
		this.setDescription("Cancels passive regeneration for players");
	}

	public void enable() {
		
	}

	public void disable() {
		
	}

	@EventHandler
	public void onEntityRegainHealth(EntityRegainHealthEvent event) {
		if (isEnabled()) {
			if (event.getRegainReason() == RegainReason.SATIATED) {
				event.setCancelled(true);
			}
		}
	}
}
