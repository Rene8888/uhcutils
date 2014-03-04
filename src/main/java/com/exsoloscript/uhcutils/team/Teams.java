package com.exsoloscript.uhcutils.team;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

import org.bukkit.ChatColor;

public class Teams implements Externalizable {

	private static final ChatColor[] colors = { ChatColor.WHITE, ChatColor.YELLOW, ChatColor.LIGHT_PURPLE, ChatColor.RED, ChatColor.AQUA, ChatColor.GREEN, ChatColor.BLUE, ChatColor.DARK_GRAY, ChatColor.GRAY, ChatColor.GOLD, ChatColor.DARK_PURPLE,
			ChatColor.DARK_RED, ChatColor.DARK_AQUA, ChatColor.DARK_GREEN, ChatColor.BLUE, ChatColor.BLACK };

	private ArrayList<Team> teams;

	private int maxTeamCount;
	private int maxTeamMemberCount;

	public Teams() {
		this.teams = new ArrayList<Team>();
	}

	public boolean addTeam(Team team) {
		if (this.getTeamCount() < this.maxTeamCount) {
			for (Team t : this.teams) {
				if (t.sameNumber(team)) {
					return false;
				}
			}
			return this.teams.add(team);
		} else {
			return false;
		}
	}

	public void setMaxTeamCount(int maxTeamCount) {
		this.maxTeamCount = maxTeamCount;
		ArrayList<Team> toRemove = new ArrayList<Team>();
		for (int i = this.teams.size(); i >= 0; i--) {
			if (this.teams.size() > this.maxTeamMemberCount) {
				Team t = this.teams.get(i);
				t.flushTeam();
				toRemove.add(t);
			} else {
				break;
			}
		}
		this.teams.removeAll(toRemove);
	}

	public void cleanUp() {
		ArrayList<Team> toRemove = new ArrayList<Team>();
		for (Team t : this.teams) {
			if (t.getTeamSize() <= 0) {
				toRemove.add(t);
			}
		}
		this.teams.removeAll(toRemove);
	}

	public void setMaxTeamMemberCount(int maxTeamMemberCount) {
		this.maxTeamMemberCount = maxTeamMemberCount;
		for (Team t : teams) {
			t.setMaxTeamMemberCount(this.maxTeamMemberCount);
		}
	}

	public boolean removeTeam(Team team) {
		return this.teams.remove(team);
	}

	public int getTeamCount() {
		return this.teams.size();
	}

	public void generateTeamColors() {
		if (this.maxTeamMemberCount > 1) {
			for (int i = 0; i < this.teams.size(); i++) {
				Team t = this.teams.get(i);
				if (i >= 0 && i <= 15) {
					t.setTeamColor(colors[i] + "");
				} else if (i >= 16 && i <= 31) {
					t.setTeamColor(colors[i % 16] + "" + ChatColor.BOLD);
				} else if (i >= 32 && i <= 47) {
					t.setTeamColor(colors[i % 16] + "" + ChatColor.UNDERLINE);
				} else if (i >= 48 && i <= 63) {
					t.setTeamColor(colors[i % 16] + "" + ChatColor.ITALIC);
				}
			}
		}
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(this.teams.size());
		for (Team team : this.teams) {
			out.writeObject(team);
		}
		out.writeInt(this.maxTeamCount);
		out.writeInt(this.maxTeamMemberCount);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		int teamsLength = in.readInt();
		this.teams = new ArrayList<Team>(teams);
		for (int i = 0; i < teamsLength; i++) {
			this.teams.add((Team) in.readObject());
		}
		this.maxTeamCount = in.readInt();
		this.maxTeamMemberCount = in.readInt();
	}
}