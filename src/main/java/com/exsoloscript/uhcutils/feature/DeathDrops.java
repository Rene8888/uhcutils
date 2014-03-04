package com.exsoloscript.uhcutils.feature;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.exsoloscript.uhcutils.UHCutils;

public class DeathDrops extends Feature {
	private ArrayList<ItemDrop> drops = new ArrayList<>();
	private Random r = new Random();

	public DeathDrops(boolean paramBoolean) {
		super(paramBoolean);
		this.setName("DeathDrops");
		this.setDescription("Adds extra loot to players on death");
		ConfigurationSection featureSection = UHCutils.getMainConfig().getConfigurationSection("feature.death-drops.items");
		for (String item : featureSection.getKeys(false)) {
			ConfigurationSection itemSection = featureSection.getConfigurationSection(item);
			String name = itemSection.getString("name");
			String sAmount = itemSection.getString("amount");
			String sChance = itemSection.getString("chance");

			if (name == null)
				continue;
			if (sAmount == null)
				sAmount = "1";
			if (sChance == null)
				sChance = "100";

			int amount = 0;
			int chance = 0;

			ItemDrop drop = null;

			try {
				amount = Integer.parseInt(sAmount);
				chance = Integer.parseInt(sChance);

				drop = new ItemDrop().setItem(Material.getMaterial(name)).setAmount(amount).setChance(chance);
			} catch (Exception e) {
				System.out.println("Unable to load DeathDrop item: " + name + ":" + sAmount + " (" + chance + "%)");
				continue;
			}

			drops.add(drop);
		}
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (isEnabled()) {
			for (ItemDrop drop : drops) {
				int i = this.r.nextInt(100);
				if (i < drop.getChance()) {
					ItemStack is = drop.getItemStack();
					if (is != null)
						event.getDrops().add(is);
				}
			}
		}
	}

	public void enable() {
	}

	public void disable() {
	}

	public class ItemDrop {
		private Material item;
		private int amount = 0;
		private int meta;
		private int chance = 0;

		public int getAmount() {
			return this.amount;
		}

		public ItemDrop setAmount(int amount) {
			this.amount = amount;
			return this;
		}

		public int getChance() {
			return this.chance;
		}

		public ItemDrop setChance(int chance) {
			this.chance = chance;
			return this;
		}

		public Material getItem() {
			return this.item;
		}

		public ItemDrop setItem(Material m) {
			this.item = m;
			return this;
		}

		public int getMeta() {
			return this.meta;
		}

		public ItemDrop setMeta(int m) {
			this.meta = m;
			return this;
		}

		public ItemStack getItemStack() {
			return new ItemStack(item, amount, (short) meta);
		}
	}
}
