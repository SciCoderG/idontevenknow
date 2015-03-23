package de.idontevenknow.engine.render;



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
		
	}

	

	
	

}
