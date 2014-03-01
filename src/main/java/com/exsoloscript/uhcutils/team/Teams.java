package com.exsoloscript.uhcutils.team;

import java.util.ArrayList;

public class Teams {

	private ArrayList<Team> teams;

	public Teams() {
		this.teams = new ArrayList<Team>();
	}

	public boolean addTeam(Team team) {
		for (Team t : this.teams) {
			if (t.sameNumber(team)) {
				return false;
			}
		}
		return this.teams.add(team);
	}

	public boolean removeTeam(Team team) {
		return this.teams.remove(team);
	}

	public int getTeamCount() {
		return this.teams.size();
	}
}
