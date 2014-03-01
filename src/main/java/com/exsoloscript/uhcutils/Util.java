package com.exsoloscript.uhcutils;

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

}
