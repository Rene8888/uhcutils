package com.exsoloscript.uhcutils.team;

import java.util.ArrayList;

import com.exsoloscript.player.UHCPlayer;

public class Team {

	private int teamnr;
	private ArrayList<UHCPlayer> players;

	private int maxTeamMemberCount;

	public Team(int teamnr) {
		this.teamnr = teamnr;
		this.players = new ArrayList<UHCPlayer>();
	}

	public int getTeamNumber() {
		return this.teamnr;
	}

	public void setMaxTeamMemberCount(int maxTeamMemberCount) {
		this.maxTeamMemberCount = maxTeamMemberCount;
		ArrayList<UHCPlayer> toRemove = new ArrayList<UHCPlayer>();
		for (int i = this.players.size(); i >= 0; i--) {
			if (this.players.size() > this.maxTeamMemberCount) {
				UHCPlayer p = this.players.get(i);
				p.setTeam(null);
				toRemove.add(p);
			} else {
				break;
			}
		}
		this.players.removeAll(toRemove);
	}

	public void flushTeam() {
		for (UHCPlayer p : this.players) {
			p.setTeam(null);
		}
		this.players.clear();
	}

	public boolean addPlayer(UHCPlayer p) {
		if (this.getTeamSize() < this.maxTeamMemberCount) {
			if (p != null) {
				boolean b = this.players.add(p);
				if (b) {
					if (p.getTeam() != null) {
						p.getTeam().removePlayer(p);
					}
					p.setTeam(this);
				}
				return b;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public ArrayList<UHCPlayer> getPlayerList() {
		return this.players;
	}

	public boolean removePlayer(UHCPlayer p) {
		if (p != null) {
			boolean b = this.players.remove(p.getUniqueId());
			if (b) {
				p.setTeam(null);
			}
			return b;
		} else {
			return false;
		}
	}

	public int getTeamSize() {
		return this.players.size();
	}

	public boolean sameNumber(Team t) {
		if (this.teamnr == t.getTeamNumber()) {
			return true;
		} else {
			return false;
		}
	}
}
