package de.idontevenknow.input;

import org.lwjgl.input.Keyboard;

import com.badlogic.gdx.Input.Keys;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.game.gameobjects.GameObject;
import de.idontevenknow.game.gameobjects.Movement;

public class InputSystem extends EngineSystem{
    
    Keyboard k;
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        for(GameObject go : getRegisteredState().getObjects()){
            for(Component c : go.getComponents()){
                if(c instanceof InputComponent){

                    if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A))
                        go.setMovement(Movement.UP_LEFT);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D))
                        go.setMovement(Movement.UP_RIGHT);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A))
                        go.setMovement(Movement.DOWN_LEFT);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D))
                        go.setMovement(Movement.DOWN_RIGHT);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_W))
                        go.setMovement(Movement.UP);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_A))
                        go.setMovement(Movement.LEFT);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_S))
                        go.setMovement(Movement.DOWN);
                    else if(Keyboard.isKeyDown(Keyboard.KEY_D))
                        go.setMovement(Movement.RIGHT);
                    else
                        go.setMovement(Movement.IDLE);
                        
                }
            }
        }
    }
}
