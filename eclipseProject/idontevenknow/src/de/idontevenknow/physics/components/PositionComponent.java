package de.idontevenknow.physics.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * position in pixel. Important, 1pixel != 1meter in Box2D!
 * Position is the Center of the Body!!
 * @author David
 *
 */
public class PositionComponent extends Component implements Poolable{

    public float x, y;
    
    @Override
    public void reset() {
        x = y = 0;
    }

}
