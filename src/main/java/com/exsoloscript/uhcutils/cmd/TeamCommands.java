package com.exsoloscript.uhcutils.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.player.UHCPlayer;
import com.exsoloscript.uhcutils.team.Team;

public class TeamCommands extends AbstractCommand {

	public TeamCommands() {
		super(UHCutils.getUHCutils(), "join");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			UHCPlayer player = UHCutils.getUHCPlayerManager().getPlayer((Player) sender);
			if (label.equalsIgnoreCase("join")) {
				if (args.length == 1) {
					sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "Invalid use of command!");
					return true;
				} else if (args.length == 2) {
					// TODO add support for admins to move a user
					if (args[0].equalsIgnoreCase("team")) {
						try {
							int id = Integer.parseInt(args[0]);
							Team t = UHCutils.getTeams().getTeamByID(id);
							if (t == null) {
								sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "No Team found with ID: " + id);
								return true;
							} else {
								boolean added = t.addPlayer(player);
								if (added) {
									sender.sendMessage(UHCutils.prefix() + ChatColor.WHITE + "You successfully joined team: " + id);
									if (t.getTeamSize() > 1) {
										sender.sendMessage(UHCutils.prefix() + ChatColor.WHITE + "Your team members are: ");
										for (UHCPlayer member : t.getPlayerList()) {
											sender.sendMessage(UHCutils.prefix() + ChatColor.WHITE + "Player: " + member.getName());
										}
									}
									return true;
								} else {
									return false;
								}
							}
						} catch (Exception e) {
							sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "The first argument hast do be a number!");
							return true;
						}
					} else if (args[0].equalsIgnoreCase("player")) {
						// TODO add command to join player to a team
						return true;
					} else {
						sender.sendMessage(UHCutils.prefix() + ChatColor.RED + "unkown parameter: " + args[0] + "!");
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
