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
	private float velocityX;
	private float velocityY;
	
	public GameObject(){
		components = new LinkedList<Component>();
	}
	
	public LinkedList<Component> getComponents() {
		return components;
	}

	public void setComponents(LinkedList<Component> components) {
		this.components = components;
	}
	
	public float getVelocityX(){
        return velocityX;
    }
    
    public void setVelocityX(float velocity){
        this.velocityX = velocity;
    }
    
    public float getVelocityY(){
        return velocityY;
    }
    
    public void setVelocityY(float velocityY){
        this.velocityY = velocityY;
    }
	
	
}
