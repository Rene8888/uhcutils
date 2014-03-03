package com.exsoloscript.uhcutils.feature;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHeads extends Feature {

	public PlayerHeads(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("PlayerHeads");
		this.setDescription("Players will drop their heads on death");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (isEnabled()) {
			ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			SkullMeta hm = (SkullMeta) head.getItemMeta();
			hm.setOwner(event.getEntity().getName());
			event.getDrops().add(0, head);
		}
	}
}
