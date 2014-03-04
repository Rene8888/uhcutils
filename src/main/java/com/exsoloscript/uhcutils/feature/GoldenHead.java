package com.exsoloscript.uhcutils.feature;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.exsoloscript.uhcutils.UHCutils;

public class GoldenHead extends Feature {

	public GoldenHead(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("GoldenHeads");
		this.setDescription("Better golden apples!");
	}

	public void enable() {
		ShapedRecipe recipe = new ShapedRecipe(getGoldenHead());
		recipe.shape(new String[] { "AAA", "ABA", "AAA" });
		recipe.setIngredient('A', Material.GOLD_INGOT);
		ItemStack skull = new ItemStack(Material.SKULL_ITEM);
		skull.setDurability((short) 3);
		recipe.getIngredientMap().put('B', skull);
		Bukkit.addRecipe(recipe);
	}

	public void disable() {
		Iterator<Recipe> ir = Bukkit.recipeIterator();

		while (ir.hasNext()) {
			ItemStack result = ir.next().getResult();
			if (result.getType().equals(Material.GOLDEN_APPLE)) {
				ItemMeta im = result.getItemMeta();
				if ((im.hasDisplayName()) && (im.getDisplayName().equals(ChatColor.GOLD + "Golden Head")))
					ir.remove();
			}
		}
	}

	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent event) {
		ItemStack is = event.getItem();
		ItemMeta im = is.getItemMeta();
		if (im.hasDisplayName() && im.getDisplayName().equals(ChatColor.GOLD + "Golden Head")) {
			event.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
			int extra = UHCutils.getMainConfig().getInt("feature.golden-heads.heal");
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100 + extra * 25, 1));
		}
	}

	@EventHandler
	public void onPreCraftEvent(PrepareItemCraftEvent event) {
		ItemStack result = event.getInventory().getResult();
		ItemMeta rm = result.getItemMeta();
		String name = "null";
		for (ItemStack is : event.getInventory().getContents())
			if (is.getType().equals(Material.SKULL_ITEM)) {
				SkullMeta skullMeta = (SkullMeta) is.getItemMeta();
				name = skullMeta.getOwner();
			}
		List<String> lore = rm.getLore();
		lore.add(ChatColor.AQUA + "Made from the head of: " + name);
		rm.setLore(lore);
		result.setItemMeta(rm);
		event.getInventory().setResult(result);
	}

	public static ItemStack getGoldenHead() {
		ItemStack head = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta im = head.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Golden Head");
		im.setLore(Arrays.asList("Some say consuming the head of a", "fallen foe strengthens the blood"));
		head.setItemMeta(im);
		return head;
	}
}
