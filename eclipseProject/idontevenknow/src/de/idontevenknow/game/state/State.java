package de.idontevenknow.game.state;

import de.idontevenknow.game.gameobjects.GameObject;

/**
 * Abstract model of every menu. Alot todo..
 * @author David
 *
 */
public abstract class State {
	private GameObject[] objects;
	
	public abstract void init();
	public abstract void update();
	public abstract void render();
	public abstract void clean();
	
	public GameObject[] getObjects() {
		return objects;
	}
	public void setObjects(GameObject[] objects) {
		this.objects = objects;
	}
	
	
}
