package de.idontevenknow.menu;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Add this Component to any Menu Button entity in a Menu
 * @author David
 *
 */
public class MenuButtonComponent extends Component implements Poolable{
    
    public float width, height;
    public String buttonText = "";
    public String target  = "";
    

    @Override
    public void reset() {
        buttonText = target = "";
        width = height = 0; 
    }

}
