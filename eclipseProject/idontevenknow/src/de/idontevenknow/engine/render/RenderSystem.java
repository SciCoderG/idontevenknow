package de.idontevenknow.engine.render;


import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;

import org.lwjgl.util.Color;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.System;
import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.game.gameobjects.GameObject;


public class RenderSystem extends System{
	
	private RenderComponent currentRenderComponent;
	private PhysicComponent currentPhysicComponent;
	
	public RenderSystem(){
		
	}

	@Override
	public void run() {
		for(GameObject go : getRegisteredState().getObjects()){
	        for(Component c : go.getComponents()){
	            if(c.getClass() == RenderComponent.class){
	                currentRenderComponent = (RenderComponent) c;
	            }
	            if(c.getClass() == PhysicComponent.class){
	            	currentPhysicComponent = (PhysicComponent) c;
	            }
	        }
	        if(currentRenderComponent!=null && currentPhysicComponent != null){
	        	render(go);
	        }
	        currentRenderComponent = null;
	        currentPhysicComponent = null;
	    }
	}

	private void render(GameObject go) {
		Color color = currentRenderComponent.getColor();
		int x = (int)currentPhysicComponent.getX();
		int y = (int)currentPhysicComponent.getY();
		int width = (int)currentPhysicComponent.getWidth();
		int height = (int)currentPhysicComponent.getHeight();
		
		glColor3f(color.getRed(), color.getBlue(), color.getGreen());
		glBegin(GL_TRIANGLE_FAN);
		
		glEnd();
	}

	

	
	

}
