package com.exsoloscript.uhcutils.feature;

import org.bukkit.event.Listener;

public abstract class Feature implements Listener {

	private boolean enabled;
	private String name;
	private String description;

	public Feature(boolean defaultEnabled) {
		this.enabled = defaultEnabled;
	}

	public abstract void enable();

	public abstract void disable();

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
