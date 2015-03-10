package de.idontevenknow.engine.physic;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.game.gameobjects.GameObject;

public class PhysicSystem extends EngineSystem{
    
    private float delta = 0;
	
    @Override
	public void run() {
		 for(GameObject go : getRegisteredState().getObjects()){
	        for(Component c : go.getComponents()){
	            if(c.getClass() == PhysicComponent.class){
	                PhysicComponent pc = (PhysicComponent) c;
	                pc.setX(pc.getX() + delta * go.getVelocityX());
	                pc.setY(pc.getY() + delta * go.getVelocityY());
	            }
	        }
	        
	    }
	}
	
	public void update(float delta){
	    this.delta = delta;
	}
	
	
}
