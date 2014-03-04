package com.exsoloscript.uhcutils.feature;

import java.util.ArrayList;

import org.bukkit.Bukkit;

import com.exsoloscript.uhcutils.UHCutils;

public class FeatureManager {

	private FeatureList features = new FeatureList();
	
	public FeatureManager() {
		this.features.add(new DeathBan(UHCutils.getMainConfig().getBoolean("feature.death-ban.enabled")));
		this.features.add(new DeathDrops(UHCutils.getMainConfig().getBoolean("feature.death-ban.enabled")));
		this.features.add(new DeathLightning(UHCutils.getMainConfig().getBoolean("feature.death-lightning.enabled")));
		this.features.add(new DeathMessage(UHCutils.getMainConfig().getBoolean("feature.death-message.enabled")));
		this.features.add(new EnderpearlDamage(UHCutils.getMainConfig().getBoolean("feature.enderpearl-damage.enabled")));
		this.features.add(new GhastDrops(UHCutils.getMainConfig().getBoolean("feature.changed-ghast-drops.enabled")));
		this.features.add(new GoldenHead(UHCutils.getMainConfig().getBoolean("feature.golden-heads.enabled")));
		this.features.add(new Nether(UHCutils.getMainConfig().getBoolean("feature.nether.enabled")));
		this.features.add(new PlayerHeads(UHCutils.getMainConfig().getBoolean("feature.player-heads.enabled")));
		this.features.add(new PlayerList(UHCutils.getMainConfig().getBoolean("feature.player-list-health.enabled")));
		this.features.add(new PotionNerfs(UHCutils.getMainConfig().getBoolean("feature.potion-nerfs.enabled")));
		this.features.add(new Recipies(UHCutils.getMainConfig().getBoolean("feature.recipies.enabled")));
		this.features.add(new Regeneration(UHCutils.getMainConfig().getBoolean("feature.regeneration.enabled")));
		this.features.add(new WitchSpawn(UHCutils.getMainConfig().getBoolean("feature.witch-spawn.enabled")));
	}
	
	public void registerEvents() {
		for (Feature f : features) {
			Bukkit.getPluginManager().registerEvents(f, UHCutils.getUHCutils());
		}
	}
	
	public Feature getForName(String name) {
		for (Feature f : features) {
			if (f.getName().equalsIgnoreCase(name)) return f;
		}
		
		return null;
	}
	
	public FeatureList getFeatureList() {
		return this.features;
	}
	
	public class FeatureList extends ArrayList<Feature> {
		private static final long serialVersionUID = 4226684108981462769L;
	}
}
