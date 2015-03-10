package de.idontevenknow.engine.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Color;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.game.gameobjects.GameObject;


public class RenderSystem extends EngineSystem{
	
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
		float x = currentPhysicComponent.getX();
		float y = currentPhysicComponent.getY();
		float width = currentPhysicComponent.getWidth();
		float height = currentPhysicComponent.getHeight();
		glColor3f(color.getRed(), color.getBlue(), color.getGreen());
		glBegin(GL_QUADS);
		{
			glVertex2f(x, y);
			glVertex2f(x, y + height);
			glVertex2f(x + width, y + height);
			glVertex2f(x + width, y);
		}
		glEnd();
	}

	

	
	

}
