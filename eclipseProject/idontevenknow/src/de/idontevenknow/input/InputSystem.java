package de.idontevenknow.input;


import com.badlogic.gdx.Input.Keys;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.game.gameobjects.GameObject;
import de.idontevenknow.game.gameobjects.Movement;

public class InputSystem extends EngineSystem{
    
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        for(GameObject go : getRegisteredState().getObjects()){
            for(Component c : go.getComponents()){
                if(c instanceof InputComponent){

                   
                        
                }
            }
        }
    }
}
