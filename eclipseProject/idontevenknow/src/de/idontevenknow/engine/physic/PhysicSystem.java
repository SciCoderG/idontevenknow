package de.idontevenknow.engine.physic;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.System;
import de.idontevenknow.game.gameobjects.GameObject;

public class PhysicSystem extends System{

	public void action(){
	    for(GameObject go : getRegisteredState().getObjects()){
	        for(Component c : go.getComponents()){
	            if(c.getClass() == PhysicComponent.class){
	                
	            }
	        }
	    }
	}
	
	
}
