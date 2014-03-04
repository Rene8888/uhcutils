package com.exsoloscript.uhcutils.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.player.UHCPlayer;
import com.exsoloscript.uhcutils.team.Team;

public class TeamCommands extends AbstractCommand {

	@SuppressWarnings("unused")
	private UHCutils plugin;

	public TeamCommands(UHCutils u) {
		super(u, "");
		this.plugin = u;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			UHCPlayer player = UHCutils.getUHCPlayerManager().getPlayer((Player) sender);
			if (label.equalsIgnoreCase("join")) {
				if (args.length == 1) {
					try {
						int id = Integer.parseInt(args[0]);
						Team t = UHCutils.getTeams().getTeamByID(id);
						if (t == null) {
							sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "No Team found with ID: " + id);
							return true;
						} else {
							boolean added = t.addPlayer(player);
							if (added) {
								sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "You successfully joined team: " + id);
								if (t.getTeamSize() > 1) {
									sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "Your team members are: ");
									for (UHCPlayer member : t.getPlayerList()) {
										sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "Player: " + member.getName());
									}
								}
								return true;
							} else {

							}
						}
						return true;
					} catch (Exception e) {
						sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "The first argument hast do be a number!");
						return true;
					}
				} else {
					return false;
				}
			} else {
				sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "Unknow command\"" + label + "\"!");
				return true;
			}
		} else {
			sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "Only a player can execute this command!");
			return true;
		}
	}
}
