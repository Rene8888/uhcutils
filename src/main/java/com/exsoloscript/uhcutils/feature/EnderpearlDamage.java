package com.exsoloscript.uhcutils.feature;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EnderpearlDamage extends Feature {

	public EnderpearlDamage(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("EnderpearlDamage");
		this.setDescription("Enderpearls cause no teleport damage");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if (isEnabled()) {
			if (event.getDamager().getType().equals(EntityType.ENDER_PEARL))
				event.setCancelled(true);
		}
	}

}
