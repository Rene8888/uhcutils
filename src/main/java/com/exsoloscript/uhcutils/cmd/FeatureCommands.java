package com.exsoloscript.uhcutils.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.exsoloscript.uhcutils.UHCutils;
import com.exsoloscript.uhcutils.feature.Feature;

public class FeatureCommands extends AbstractCommand {

	public FeatureCommands() {
		super(UHCutils.getUHCutils(), "feature");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("feature")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("list")) {
						player.sendMessage(ChatColor.GOLD + featuresToString());
						return true;
					}
					if (args[0].equalsIgnoreCase("toggle")) {
						if (args.length > 1) {
							Feature f = UHCutils.getFeatureManager().getForName(args[1]);
							if (f != null) {
								f.setEnabled(!f.isEnabled());
								player.sendMessage(ChatColor.GOLD + "Toggeled feature " + f.getName() + " to " + f.isEnabled());
								return true;
							} else {
								player.sendMessage(ChatColor.RED + "Unknown feature: Do /feature list for more information");
								return true;
							}
						} else {
							player.sendMessage(ChatColor.RED + "Too few arguments: /feature toggle <feature>");
							return true;
						}
					}
				} else {
					if (!player.isOp()) player.sendMessage(ChatColor.GOLD + featuresToString());
					else {
						player.sendMessage(ChatColor.RED + "Too few arguments: \n" + 
										   " - /feature toggle <feature> \n" + 
										   " - /feature list");
					}
					return true;
				}
			}
		}
		
		return false;
	}

	public String featuresToString() {
		String ret = "";
		
		for (Feature f : UHCutils.getFeatureManager().getFeatureList()) {
			ret += " - " + f.getName() + ": " + f.isEnabled() + "\n" +
				   "   " + f.getDescription() + "\n";
		}
		
		return ret;
	}
	
}
