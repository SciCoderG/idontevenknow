package de.idontevenknow.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import de.idontevenknow.CompMappers;

/**
 * 
 * Mainly used for stepping the Box2D World. Gets all entities with
 * PhysicsModifierComponents and runs the scheduled changes on the Box2d body.
 * Uses a fixed timestep on the Box2D steps, because it makes the physics
 * simulation a lot more stable.
 * 
 * @author David
 *
 */
public class PhysicsSystem extends IteratingSystem {

    private World world;
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private int velocityIterations, positionIterations;
    private boolean debugRendering;

    public PhysicsSystem(int velocityIterations, int positionIterations,
            int priority) {
        this(velocityIterations, positionIterations, priority, false);
    }

    public PhysicsSystem(int velocityIterations, int positionIterations,
            int priority, boolean debugRendering) {
        super(Family.all(PhysicsModifierComponent.class).get(), priority);
        this.velocityIterations = velocityIterations;
        this.positionIterations = positionIterations;
        this.debugRendering = debugRendering;
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
        if(debugRendering){
           //TODO set camera! debugRenderer.render(world, projMatrix);
        }
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

    public boolean isDebugRendering() {
        return debugRendering;
    }

    public void setDebugRendering(boolean debugRendering) {
        this.debugRendering = debugRendering;
    }
    
    
}
