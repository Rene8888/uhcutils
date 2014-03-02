package com.exsoloscript.uhcutils.team;

import java.util.ArrayList;

public class Teams {

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
}
