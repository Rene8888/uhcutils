package com.exsoloscript.uhcutils.feature;

import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.exsoloscript.uhcutils.UHCutils;

public class PlayerList extends Feature {

	private static int task_id = -1;
	private static WeakHashMap<Player, Double> players = new WeakHashMap<Player, Double>();
	private static final int health_scaling = UHCutils.getMainConfig().getInt("feature.player-list-health.scaling");
//	private static final boolean round_health = UHCutils.getMainConfig().getBoolean("feature.player-list-health.round-health");
	private static Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
	private static Objective obj_player_list = null;
	private static Objective obj_player_name = null;

	public PlayerList(boolean defaultEnabled) {
		super(defaultEnabled);
		setName("PlayerList");
		setDescription("Player's health shown in player list and under their name");
	}

	public static void updatePlayerListHealth(Player player) {
		String listName = ChatColor.stripColor(player.getDisplayName());
		if (UHCutils.getMainConfig().getBoolean("feature.player-list-health.colours")) {
			listName = listName.substring(0, Math.min(listName.length(), 14));
			if (player.getHealth() <= 6) {
				listName = ChatColor.RED + listName;
			} else if (player.getHealth() <= 12) {
				listName = ChatColor.YELLOW + listName;
			} else {
				listName = ChatColor.GREEN + listName;
			}
		} else {
			listName = listName.substring(0, Math.min(listName.length(), 16));
		}
		player.setPlayerListName(listName);
//		if (round_health)
//			int health = Math.ceil(player.getHealth());
		obj_player_list.getScore(Bukkit.getOfflinePlayer(listName)).setScore((int) (player.getHealth() * health_scaling));
		obj_player_name.getScore(Bukkit.getOfflinePlayer(ChatColor.stripColor(player.getDisplayName()))).setScore((int) (player.getHealth() * health_scaling));
	}

	public static void updatePlayers(Player[] toUpdate) {
		for (Player localPlayer : toUpdate) {
			Double localDouble = (Double) players.get(localPlayer);
			if (localDouble == null) {
				localDouble = Double.valueOf(0.0D);
				players.put(localPlayer, localDouble);
			}
			if (!localDouble.equals(Double.valueOf(localPlayer.getHealth())))
				updatePlayerListHealth(localPlayer);
		}
	}

	public void enable() {
		task_id = Bukkit.getScheduler().scheduleSyncRepeatingTask(UHCutils.getPlugin(), new Runnable() {
			public void run() {
				PlayerList.updatePlayers(Bukkit.getOnlinePlayers());
			}
		}, 1L, UHCutils.getMainConfig().getInt("feature.player-list-health.delay"));
		initializeScoreboard();
	}

	public void disable() {
		if (task_id >= 0) {
			Bukkit.getScheduler().cancelTask(task_id);
			task_id = -1;
		}
		if (board != null) {
			board.clearSlot(DisplaySlot.PLAYER_LIST);
			board.clearSlot(DisplaySlot.BELOW_NAME);
			for (Player localPlayer : Bukkit.getOnlinePlayers())
				localPlayer.setPlayerListName(localPlayer.getDisplayName());
		}
	}

	private void initializeScoreboard() {
		try {
			board.registerNewObjective("UHCHealth", "dummy");
		} catch (IllegalArgumentException e) {
		}
		try {
			board.registerNewObjective("UHCHealthName", "dummy");
		} catch (IllegalArgumentException e) {
		}
		obj_player_list = board.getObjective("UHCHealth");
		obj_player_name = board.getObjective("UHCHealthName");
		obj_player_name.setDisplayName(ChatColor.translateAlternateColorCodes('&', UHCutils.getMainConfig().getString("feature.player-list-health.belowNameUnit")).replaceAll("&h", "♥"));
		obj_player_list.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		if (UHCutils.getMainConfig().getBoolean("feature.player-list-health.belowName")) {
			obj_player_name.setDisplaySlot(DisplaySlot.BELOW_NAME);
		} else {
			Objective localObjective = board.getObjective(DisplaySlot.BELOW_NAME);
			if ((localObjective != null) && (localObjective.getName().equals("UHCHealthName")))
				board.clearSlot(DisplaySlot.BELOW_NAME);
		}
	}
}
