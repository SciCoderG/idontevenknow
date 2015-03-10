package de.idontevenknow.game.gameobjects;

import java.util.LinkedList;

import de.idontevenknow.engine.Component;

/**
 * Abstract model of every GameObject in the Game
 * @author David
 *
 */
public abstract class GameObject {
	protected LinkedList<Component> components;

	public LinkedList<Component> getComponents() {
		return components;
	}

	public void setComponents(LinkedList<Component> components) {
		this.components = components;
	}
	
	
}
