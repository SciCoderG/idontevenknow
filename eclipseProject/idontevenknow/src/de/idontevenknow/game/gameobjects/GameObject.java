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
	private float maxVelocity;
	
	public GameObject(float veloX, float veloY, float maxVelo){
		components = new LinkedList<Component>();
		
		velocityX = veloX;
		velocityY = veloY;
		maxVelocity = maxVelo;
	}
	
	//----------------------Getters and Setters------------------------------//
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
    
    public float getMaxVelocity(){
        return maxVelocity;
    }
    
    public void setMaxVelocity(float maxVelocity){
        this.maxVelocity = maxVelocity;
    }
    //---------------------------------------------------------------------//
	
	
}
