package com.exsoloscript.uhcutils.feature;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GhastDrops extends Feature {

	public GhastDrops(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("GhastDrops");
		this.setDescription("Ghast drop other items instead of taers");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent paramEntityDeathEvent) {
		if (isEnabled()) {
			if (paramEntityDeathEvent.getEntityType().equals(EntityType.GHAST)) {
				List<ItemStack> drops = paramEntityDeathEvent.getDrops();
				ItemStack replace = new ItemStack(Material.GOLD_INGOT);
				ItemMeta rm = replace.getItemMeta();
				rm.setDisplayName(ChatColor.GOLD + "Totaly a ghast tear!");
				replace.setItemMeta(rm);
				for (ItemStack is : drops) {
					if (is.getType() == Material.GHAST_TEAR) {
						drops.remove(is);
						drops.add(replace);
					}
				}
			}
		}
	}
}
