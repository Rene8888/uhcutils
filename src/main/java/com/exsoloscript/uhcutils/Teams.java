package com.exsoloscript.uhcutils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Teams {

	private Scoreboard main;
	private final Pattern teamPattern = Pattern.compile("^UHC[\\d]++");
	
	public Teams() {
		this.main = Bukkit.getScoreboardManager().getMainScoreboard();
	}
	
	public Set<Team> getUHCTeams() {
		Set<Team> teams = new HashSet<Team>();
		
		for (Team t : main.getTeams()) {
			if (teamPattern.matcher(t.getName()).matches()) teams.add(t);
		}
		
		return teams;
	}
	
	public Team getEmptyTeam(boolean createIfNone) {
		for (int i = 0; i < main.getTeams().size(); i++) {
			Team t = main.getTeam("UHC" + i);
			if (t == null && createIfNone) 
				return main.registerNewTeam("UHC" + i);
			else 
				if (t.getSize() == 0) return t;
		}
		
		return null;
	}
	
	public void joinTeam(OfflinePlayer player, Team team) {
		team.addPlayer(player);
		for (OfflinePlayer p : team.getPlayers()) {
			if (p.isOnline()) {
				p.getPlayer().sendMessage(UHCutils.prefix() + player.getPlayer().getName() + " has joined your team!");
			}
		}
	}
	
	public void removePlayer(OfflinePlayer player) {
		for (Team t : main.getTeams()) {
			if (t.getPlayers().contains(player)) {
				t.removePlayer(player);
				for (OfflinePlayer p : t.getPlayers()) p.getPlayer().sendMessage(UHCutils.prefix() + player.getPlayer().getName() + " left your team!");
			}
		}
	}
	
	public void empty() {
		for (Team t : main.getTeams()) {
			if (isUHCTeam(t)) {
				for (OfflinePlayer p : t.getPlayers()) {
					t.removePlayer(p);
					p.getPlayer().sendMessage(UHCutils.prefix() + "Your team was enptied!");
				}
			}
		}
	}
	
	public boolean isUHCTeam(Team t) {
		return teamPattern.matcher(t.getName()).matches();
	}
}
