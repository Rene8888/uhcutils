package com.exsoloscript.uhcutils;

public class Game {

	private boolean started;

	public Game() {
		this.started = false;
	}

	public void start() {
		this.started = true;
	}

	public boolean isStarted() {
		return this.started;
	}

}
