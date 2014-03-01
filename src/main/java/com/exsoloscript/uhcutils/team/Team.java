package com.exsoloscript.uhcutils.team;

import java.util.ArrayList;
import java.util.UUID;

import com.exsoloscript.player.UHCPlayer;

public class Team {

	private int teamnr;
	private ArrayList<UUID> players;

	public Team(int teamnr) {
		this.teamnr = teamnr;
		this.players = new ArrayList<UUID>();
	}

	public int getTeamNumber() {
		return this.teamnr;
	}

	public boolean addPlayer(UHCPlayer p) {
		if (p != null) {
			return this.players.add(p.getUniqueId());
		} else {
			return false;
		}
	}

	public boolean removePlayer(UHCPlayer p) {
		if (p != null) {
			return this.players.remove(p.getUniqueId());
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
