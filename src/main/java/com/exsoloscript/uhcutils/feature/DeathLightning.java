package com.exsoloscript.uhcutils.feature;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathLightning extends Feature {

	public DeathLightning(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("DeathLightning");
		this.setDescription("Fake lightning on a players death");
	}

	public void enable() {
		
	}

	public void disable() {
		
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (isEnabled()) {
			event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
		}
	}
}
