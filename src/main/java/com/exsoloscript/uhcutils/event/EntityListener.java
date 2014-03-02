package com.exsoloscript.uhcutils.event;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityListener implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntityType() == EntityType.GHAST) {
			for (ItemStack is : event.getDrops()) {
				if (is.getType() == Material.GHAST_TEAR) {
					event.getDrops().remove(is);
					event.getDrops().add(new ItemStack(Material.GOLD_INGOT));
					break;
				}
			}
		}
	}
}