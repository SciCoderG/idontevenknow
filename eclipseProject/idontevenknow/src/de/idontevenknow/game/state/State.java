package de.idontevenknow.game.state;

import java.util.ArrayList;

import de.idontevenknow.game.gameobjects.GameObject;

/**
 * Abstract model of every menu. Alot todo..
 * @author David
 *
 */
public abstract class State {
	protected ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void render();
	public abstract void clean();
	
	public State(){
		init();
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<GameObject> objects) {
		this.objects = objects;
	}
	
	
}
