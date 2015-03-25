package de.idontevenknow.physics.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import de.idontevenknow.CompMappers;
import de.idontevenknow.physics.components.PhysicsModifierComponent;

/**
 * 
 * Mainly used for stepping the Box2D World. Gets all entities with
 * PhysicsModifierComponents and runs the scheduled changes on the Box2d body.
 * TODO Uses a fixed timestep on the Box2D steps, because it makes the physics
 * simulation a lot more stable.
 * 
 * @author David
 *
 */
public class PhysicsSystem extends IteratingSystem {

    private World world;
    private Vector2 gravity = new Vector2(0,0);
    private int velocityIterations, positionIterations;
    private float scale = 64.0f;

    public PhysicsSystem(int velocityIterations, int positionIterations,
            int priority) {
        super(Family.all(PhysicsModifierComponent.class).get(), priority);
        world = new World(gravity, true);
        this.velocityIterations = velocityIterations;
        this.positionIterations = positionIterations;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsModifierComponent modifier = CompMappers.physicsModifier
                .get(entity);
        for (Runnable runnable : modifier.runnables) {
            runnable.run();
        }
        entity.remove(PhysicsModifierComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        world.step(deltaTime, velocityIterations, positionIterations);

        super.update(deltaTime);
    }

    // Getter / Setter
    public World getWorld() {
        return world;
    }

    public int getVelocityIterations() {
        return velocityIterations;
    }

    public void setVelocityIterations(int velocityIterations) {
        this.velocityIterations = velocityIterations;
    }

    public int getPositionIterations() {
        return positionIterations;
    }

    public void setPositionIterations(int positionIterations) {
        this.positionIterations = positionIterations;
    }
    
    public float getScale() {
        return this.scale;
    }
    
    /**
     * Used to compute between box2D coordinates and opengl cooredinates
     * standard: 64
     * @param scale
     */
    public void setScale(float scale){
        this.scale = scale;
    }
    
    
    
    public void setGravity(Vector2 gravity){
        world.setGravity(gravity);
    }
}
