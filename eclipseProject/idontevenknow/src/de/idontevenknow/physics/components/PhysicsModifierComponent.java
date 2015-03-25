package de.idontevenknow.physics.components;

import java.util.ArrayList;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Add this Component if you want to schedule a change of the PhysicsBody in Box2D
 * 
 * 
 * @author David Liebemann
 *
 */
public class PhysicsModifierComponent extends Component implements Poolable{

    public final ArrayList<Runnable> runnables = new ArrayList();

    @Override
    public void reset() {
        runnables.clear();
    }

    /**
     * Example for scheduling a modification:
     * modifier.schedule(() -> {
     * bodyComponent.setGravityScale(1);
       bodyComponent.setAwake(true);
     * });
     * @param runnable 
     */
    public void schedule(Runnable runnable) {
        runnables.add(runnable);
    }
}
