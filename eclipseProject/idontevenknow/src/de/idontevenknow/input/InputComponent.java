package de.idontevenknow.input;

import org.lwjgl.input.Keyboard;

import com.badlogic.gdx.Input.Keys;

import de.idontevenknow.engine.Component;

public class InputComponent extends Component{
    
    private int key;
    
    public InputComponent(){
        
    }
    
    public int getKeyDown(){
        return key;
    }
    
    public void calculateNewVelocity(float minVelo, float maxVelo, float velo){
        
    }

}
