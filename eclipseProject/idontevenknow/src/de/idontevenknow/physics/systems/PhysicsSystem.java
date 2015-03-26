package de.idontevenknow.physics.systems;

import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

import de.idontevenknow.CompMappers;
import de.idontevenknow.math.utils.Point;
import de.idontevenknow.physics.components.PhysicsBodyComponent;
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
    private Vector2 gravity = new Vector2(0, 0);
    private int velocityIterations, positionIterations;
    private float scale, scaleInv;

    public PhysicsSystem(int velocityIterations, int positionIterations, float scale,
            int priority) {
        super(Family.all(PhysicsModifierComponent.class).get(), priority);
        world = new World(gravity, true);
        this.velocityIterations = velocityIterations;
        this.positionIterations = positionIterations;
        this.scale = scale;
        this.scaleInv = 1.0f / scale;
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
     * 
     * @param scale
     */
    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setGravity(Vector2 gravity) {
        world.setGravity(gravity);
    }

    /**
     * Convert world to box2d coordinates
     */
    public float toBox2D(float pixel) {
        return pixel * scaleInv;
    }

    /**
     * Convert box2d to world coordinates
     */
    public float toWorld(float num) {
        return num * scale;
    }

    /**
     * Convert world to box2d coordinates
     */
    public Vector2 toBox2D(float x, float y, Vector2 out) {
        out.set(x * scaleInv, y * scaleInv);
        return out;
    }

    /**
     * Convert world to box2d coordinates
     */
    public Vector2 toBox2D(Vector2 in, Vector2 out) {
        out.set(in.x * scaleInv, in.y * scaleInv);
        return out;
    }

    /**
     * Convert box2d to world coordinates
     */
    public Vector2 toWorld(Vector2 in, Vector2 out) {
        out.set(in.x * scale, in.y * scale);
        return out;
    }

    /**
     * Convert a list of points to Box2D coordinates
     * @param pointList
     * @return
     */
    public Vector2[] toBox2D(List<Point> pointList) {
        Vector2[] returner = new Vector2[pointList.size()];
        for (int pointCount = 0; pointCount < returner.length; pointCount++) {
            Point p = pointList.get(pointCount);
            returner[pointCount] = new Vector2(p.x * scale, p.y * scale);
        }
        return returner;
    }

    /**
     * destroys the Box2D body of a PhysicsBodyComponent. Does not delete the Component!
     * @param pBody
     */
    public void destroy(PhysicsBodyComponent pBody){
        world.destroyBody(pBody.getBody());
    }
    
    /**
     * resets all of the bodies and joints in the Box2D world
     */
    public void reset() {
        if (world.isLocked()) {
            throw new GdxRuntimeException("PhysicsSystem.reset() called while Box2D world was locked");
        }

        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            world.destroyBody(body);
        }

        Array<Joint> joints = new Array<Joint>();
        world.getJoints(joints);
        for (Joint joint : joints) {
            world.destroyJoint(joint);
        }
    }
}
