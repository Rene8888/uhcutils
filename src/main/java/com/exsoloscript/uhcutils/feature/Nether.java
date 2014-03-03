package com.exsoloscript.uhcutils.feature;

import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;

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
}
