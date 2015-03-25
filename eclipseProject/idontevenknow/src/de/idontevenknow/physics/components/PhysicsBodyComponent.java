package de.idontevenknow.physics.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.Pool.Poolable;

import de.idontevenknow.physics.systems.PhysicsSystem;

/**
 * Add this Component to every entity with any kind of physics logic
 * 
 * @author David Liebemann
 *
 */
public class PhysicsBodyComponent extends Component implements Poolable {

    private Body body;
    private PhysicsSystem system;
    private Entity entity;

    /**
     * initialises the physics-body
     * 
     * @param bodyDef
     *            Box2D body definition
     * @param system
     *            PhysicsSystem
     * @param entity
     *            Entity to which the Component is added
     */
    public void init(BodyDef bodyDef, PhysicsSystem system, Entity entity) {
        if(body != null){
            reset();
        }
        this.system = system;
        body = system.getWorld().createBody(bodyDef);
        this.entity = entity;
    }

    @Override
    public void reset() {
        system.getWorld().destroyBody(body);
        system = null;
        entity = null;
    }

    public Body getBody() {
        return body;
    }

    public Entity getEntity() {
        return entity;
    }

    public PhysicsSystem getSystem() {
        return system;
    }
    
    /**
     * Position in pixel, if the unit vector of Box2D equals physicssystem.getScale() * unit vector
     * @return
     */
    public Vector2 getPosition(){
        return body.getPosition().scl(system.getScale());
    }
}
