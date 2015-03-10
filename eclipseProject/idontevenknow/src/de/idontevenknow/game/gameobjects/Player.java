package de.idontevenknow.game.gameobjects;

import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.engine.render.RenderComponent;

public class Player extends GameObject{
    
	public Player(){
		components.add(new RenderComponent());
		components.add(new PhysicComponent());
	}
}
