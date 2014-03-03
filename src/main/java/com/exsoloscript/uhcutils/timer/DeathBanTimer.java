package com.exsoloscript.uhcutils.timer;

import com.exsoloscript.player.UHCPlayer;

public class DeathBanTimer implements Runnable {

	private int time;
	private UHCPlayer player;
	
	public DeathBanTimer(UHCPlayer player, int sec) {
		this.time = sec;
		this.player = player;
	}
	
	public void run() {
		if (time > 0) time--;
		else kick();
	}

	public void kick() {
		player.kickPlayer("You died! Thanks for playing!");
	}
}
