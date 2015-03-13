package de.idontevenknow.game.gameobjects;

import org.lwjgl.util.Color;

import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.engine.render.RenderComponent;

public class Player extends GameObject{
    
	public Player(float veloX, float veloY, float maxVelo){
	    super(veloX, veloY, maxVelo);
		components.add(new RenderComponent(new Color(1,0,0,1)));
		components.add(new PhysicComponent(100, 100, 200, 200));
	}
}
