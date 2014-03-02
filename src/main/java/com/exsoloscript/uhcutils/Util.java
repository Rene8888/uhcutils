package com.exsoloscript.uhcutils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Util {

	public static int getPlayerCountWithoutOps() {
		int mortals = 0;
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!p.isOp())
				mortals++;
		}
		return mortals;
	}

	public static Player getPlayerByUUID(UUID uuid) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getUniqueId().equals(uuid)) {
				return p;
			}
		}
		return null;
	}

}
