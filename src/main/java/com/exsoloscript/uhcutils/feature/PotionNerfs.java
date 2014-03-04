package com.exsoloscript.uhcutils.feature;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import com.exsoloscript.uhcutils.UHCutils;

public class PotionNerfs extends Feature {

	public PotionNerfs(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("PotionNerfs");
		this.setDescription("Applies nerfs to overpowered potions");
	}

	public void enable() {

	}

	public void disable() {

	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent event) {
		if ((isEnabled()) && (event.getInventory().getType().equals(InventoryType.BREWING))) {
			boolean disableSplash = UHCutils.getMainConfig().getBoolean("features.potionNerfs.disableSplash");
			boolean disableGlowstone = UHCutils.getMainConfig().getBoolean("features.potionNerfs.disableGlowstone");
			if (event.isShiftClick()) {
				if ((disableSplash) && (event.getCurrentItem().getType().equals(Material.SULPHUR)))
					cancel(event);
				if ((disableGlowstone) && (event.getCurrentItem().getType().equals(Material.GLOWSTONE_DUST)))
					cancel(event);
			} else if (event.getSlotType().equals(InventoryType.SlotType.FUEL)) {
				if ((disableSplash) && (event.getView().getCursor().getType().equals(Material.SULPHUR)))
					cancel(event);
				if ((disableGlowstone) && (event.getView().getCursor().getType().equals(Material.GLOWSTONE_DUST)))
					cancel(event);
			}
		}
	}

	@EventHandler
	public void onPlayerEatEvent(PlayerItemConsumeEvent event) {
		if ((isEnabled()) && (UHCutils.getMainConfig().getBoolean("features.potionNerfs.disableAbsorb"))) {
			ItemStack localItemStack = event.getItem();
			if (localItemStack.getType().equals(Material.GOLDEN_APPLE)) {
				final String name = event.getPlayer().getName();
				Bukkit.getScheduler().scheduleSyncDelayedTask(UHCutils.getUHCutils(), new Runnable() {
					public void run() {
						Player p = Bukkit.getPlayerExact(name);
						p.removePotionEffect(PotionEffectType.ABSORPTION);
					}
				});
			}
		}
	}

	@EventHandler
	public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {
		if ((isEnabled()) && (event.getDestination().getType().equals(InventoryType.BREWING))) {
			if ((event.getItem().getType().equals(Material.SULPHUR)) && (UHCutils.getMainConfig().getBoolean("features.potionNerfs.disableSplash")))
				event.setCancelled(true);
			if ((event.getItem().getType().equals(Material.GLOWSTONE_DUST)) && (UHCutils.getMainConfig().getBoolean("features.potionNerfs.disableGlowstone")))
				event.setCancelled(true);
		}
	}

	public void cancel(InventoryClickEvent event) {
		event.setCancelled(true);
		event.getWhoClicked().closeInventory();
		((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You don't have permission to use that ingredient!");
	}
}
