package com.exsoloscript.uhcutils.cmd;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.Util;

public class JoinCommands extends AbstractCommand {

	@SuppressWarnings("unused")
	private UHCutils plugin;

	public JoinCommands(UHCutils u) {
		super(u, "coinjoin", "byebye");
		this.plugin = u;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("canjoin")) {
			sender.sendMessage(UHCutils.prefix() + "Currently are " + Bukkit.getOnlinePlayers().length + "/" + Bukkit.getMaxPlayers() + " players online. " + (Bukkit.getMaxPlayers() - Util.getPlayerCountWithoutOps()) + " slots are free!");
			return true;
		} else if (label.equalsIgnoreCase("whitelistall")) {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("clear")) {
					for (OfflinePlayer op : Bukkit.getServer().getWhitelistedPlayers()) {
						op.setWhitelisted(false);
					}
					Bukkit.getServer().setWhitelist(false);
					sender.sendMessage(ChatColor.GOLD + "Whitelist cleared and turned off");
					return true;
				}
				return false;
			}
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				p.setWhitelisted(true);
			}
			Bukkit.getServer().setWhitelist(true);
			sender.sendMessage(ChatColor.GOLD + "All players added to whitelist and activated the whitelist");
			return true;
		} else if (label.equalsIgnoreCase("byebye")) {
			if (args.length > 0) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					target.setWhitelisted(false);
					Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "You died! Thanks for playing!", null, null);
					target.kickPlayer("You died! Thanks for playing!");
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}
}
