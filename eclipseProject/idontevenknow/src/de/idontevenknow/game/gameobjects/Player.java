package de.idontevenknow.game.gameobjects;

import org.lwjgl.util.Color;

import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.engine.render.RenderComponent;

public class Player extends GameObject{
    
	public Player(){
		components.add(new RenderComponent(new Color(1,0,0,1)));
		components.add(new PhysicComponent(0,0,10,10,1,1,4));
	}
}
