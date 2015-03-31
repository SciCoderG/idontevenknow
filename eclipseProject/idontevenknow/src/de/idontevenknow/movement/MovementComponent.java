package de.idontevenknow.movement;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;


public class MovementComponent extends Component implements Poolable{

    public Vector2 velocity = new Vector2();
    public float speed;

    @Override
    public void reset() {
        velocity.setZero();
        speed = 0f;
    }

}
