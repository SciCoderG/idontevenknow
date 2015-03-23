package de.idontevenknow.movement;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.engine.physic.PhysicComponent;
import de.idontevenknow.game.gameobjects.GameObject;
import de.idontevenknow.game.gameobjects.Movement;

public class MovementSystem extends EngineSystem{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(GameObject go : getRegisteredState().getObjects()){
            for(Component c : go.getComponents()){
                if(c instanceof MovementComponent){
                    PhysicComponent pc = new PhysicComponent();
                    for(int i = 0; i < go.getComponents().size(); i++){
                        if(go.getComponents().get(i) instanceof PhysicComponent){
                            pc = (PhysicComponent) go.getComponents().get(i);
                        }
                    }
                    if(go.getMovement() == Movement.UP){
                        pc.setVelocityY(pc.getMaxVelocity());
                    }else if(go.getMovement() == Movement.DOWN){
                        
                    }else if(go.getMovement() == Movement.LEFT){
                        
                    }else if(go.getMovement() == Movement.RIGHT){
                        
                    }else if(go.getMovement() == Movement.UP_LEFT){
                        
                    }else if(go.getMovement() == Movement.UP_RIGHT){
                        
                    }else if(go.getMovement() == Movement.DOWN_LEFT){
                        
                    }else if(go.getMovement() == Movement.DOWN_RIGHT){
                        
                    }
                }
            }
        }
    }

}
