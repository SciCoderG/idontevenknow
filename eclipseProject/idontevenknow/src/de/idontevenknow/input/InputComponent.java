package de.idontevenknow.input;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Rudimentary solution of the InputComponent
 * @author David
 *
 */
public class InputComponent extends Component implements Poolable{

    public Vector2 direction = new Vector2();
    
    @Override
    public void reset() {
        direction.setZero();
    }
    
    
}
