package de.idontevenknow.engine.input;

import org.lwjgl.input.Keyboard;

import com.badlogic.gdx.Input.Keys;

import de.idontevenknow.engine.Component;
import de.idontevenknow.engine.EngineSystem;
import de.idontevenknow.game.gameobjects.GameObject;

public class InputSystem extends EngineSystem{
    
    Keyboard k;
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        for(GameObject go : getRegisteredState().getObjects()){
            for(Component c : go.getComponents()){
                if(c instanceof InputComponent){
                    InputComponent ic = (InputComponent) c;
                    ic.setKey(Keyboard.getEventKey());
                    System.out.println(ic.getKey() + " " + Keys.A);
                }
            }
        }
        
    }
}
