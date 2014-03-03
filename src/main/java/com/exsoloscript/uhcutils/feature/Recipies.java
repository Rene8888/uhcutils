package com.exsoloscript.uhcutils.feature;

import java.util.Collection;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class Recipies extends Feature {

	public Recipies(boolean defaultEnabled) {
		super(defaultEnabled);
		this.setName("UHCRecpies");
		this.setDescription("Handles changed recipes");
	}

	public void enable() {
		ShapedRecipe gCarrotRecipe = new ShapedRecipe(new ItemStack(Material.GOLDEN_CARROT, 1));
		gCarrotRecipe.shape(new String[] { "AAA", "ABA", "AAA" });
		gCarrotRecipe.setIngredient('A', Material.GOLD_INGOT);
		gCarrotRecipe.setIngredient('B', Material.CARROT_ITEM);
		Bukkit.addRecipe(gCarrotRecipe);
		ShapelessRecipe gMelonRecipe = new ShapelessRecipe(new ItemStack(Material.SPECKLED_MELON, 1));
		gMelonRecipe.addIngredient(Material.GOLD_BLOCK);
		gMelonRecipe.addIngredient(Material.MELON);
		Bukkit.addRecipe(gMelonRecipe);
	}

	public void disable() {
		Iterator<Recipe> localIterator = Bukkit.recipeIterator();
		while (localIterator.hasNext()) {
			Recipe recipe = (Recipe) localIterator.next();
			if (recipe.getResult().getType().equals(Material.SPECKLED_MELON)) {
				if (recipeContainsMaterial(recipe, Material.GOLD_BLOCK))
					localIterator.remove();
			} else if ((recipe.getResult().getType().equals(Material.GOLDEN_CARROT)) && (recipeContainsMaterial(recipe, Material.GOLD_INGOT)))
				localIterator.remove();
		}
	}

	@EventHandler
	public void onPrepareItemCraft(PrepareItemCraftEvent event) {
		if (isEnabled()) {
			Recipe recipe = event.getRecipe();
			if (recipe.getResult().getType().equals(Material.GOLDEN_APPLE)) {
				if ((recipeContainsMaterial(recipe, Material.GOLD_BLOCK)))
					event.getInventory().setResult(new ItemStack(Material.AIR));
			} else if (recipe.getResult().getType().equals(Material.SPECKLED_MELON)) {
				if (recipeContainsMaterial(recipe, Material.GOLD_NUGGET))
					event.getInventory().setResult(new ItemStack(Material.AIR));
				else if ((recipeContainsMaterial(recipe, Material.GOLD_BLOCK)))
					event.getInventory().setResult(new ItemStack(Material.AIR));
			} else if (recipe.getResult().getType().equals(Material.GOLDEN_CARROT))
				if (recipeContainsMaterial(recipe, Material.GOLD_NUGGET)) {
					event.getInventory().setResult(new ItemStack(Material.AIR));
				} else if ((recipeContainsMaterial(recipe, Material.GOLD_INGOT)))
					event.getInventory().setResult(new ItemStack(Material.AIR));
		}
	}

	private boolean recipeContainsMaterial(Recipe recipe, Material material) {
		Collection<ItemStack> items = null;

		if ((recipe instanceof ShapedRecipe))
			items = ((ShapedRecipe) recipe).getIngredientMap().values();
		if ((recipe instanceof ShapelessRecipe))
			items = ((ShapelessRecipe) recipe).getIngredientList();
		if (null == null)
			return false;

		for (ItemStack is : items) {
			if (is.getType().equals(material))
				return true;
		}
		return false;
	}
}
