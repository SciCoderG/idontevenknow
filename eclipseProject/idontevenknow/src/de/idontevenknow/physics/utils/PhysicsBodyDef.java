package de.idontevenknow.physics.utils;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import de.idontevenknow.physics.systems.PhysicsSystem;

/**
 * Nearly exactly the class PhysixBodyDef by Santo Pfingsten in the gdw-commons-gdx project
 * Easier to use BodyDef of a Box2D Body
 * @author Santo Pfingsten
 * @author David
 *
 */
public class PhysicsBodyDef extends BodyDef {

    private final PhysicsSystem system;

    public PhysicsBodyDef(BodyType type, PhysicsSystem system) {
        this.type = type;
        this.system = system;
    }
    
    

    /** The body type: static, kinematic, or dynamic. Note: if a dynamic body would have zero mass, the mass is set to one. **/
    public PhysicsBodyDef type(BodyType value) {
        type = value;
        return this;
    }

    /** The world position of the body. Avoid creating bodies at the origin since this can lead to many overlapping shapes. **/
    public PhysicsBodyDef position(Vector2 p) {
        position.set(system.toBox2D(p.x), system.toBox2D(p.y));
        return this;
    }

    public PhysicsBodyDef position(float x, float y) {
        position.set(system.toBox2D(x), system.toBox2D(y));
        return this;
    }

    /** The world angle of the body in radians. **/
    public PhysicsBodyDef angle(float value) {
        angle = value;
        return this;
    }

    /** The linear velocity of the body's origin in world co-ordinates. **/
    public PhysicsBodyDef angularVelocity(Vector2 value) {
        linearVelocity.set(value);
        return this;
    }

    /** The angular velocity of the body. **/
    public PhysicsBodyDef angularVelocity(float value) {
        angularVelocity = value;
        return this;
    }

    /** Linear damping is use to reduce the linear velocity. The damping parameter can be larger than 1.0f but the damping effect
     * becomes sensitive to the time step when the damping parameter is large. **/
    public PhysicsBodyDef linearDamping(float value) {
        linearDamping = value;
        return this;
    }

    /** Angular damping is use to reduce the angular velocity. The damping parameter can be larger than 1.0f but the damping effect
     * becomes sensitive to the time step when the damping parameter is large. **/
    public PhysicsBodyDef angularDamping(float value) {
        angularDamping = value;
        return this;
    }

    /** Set this flag to false if this body should never fall asleep. Note that this increases CPU usage. **/
    public PhysicsBodyDef allowSleep(boolean value) {
        allowSleep = value;
        return this;
    }

    /** Is this body initially awake or sleeping? **/
    public PhysicsBodyDef awake(boolean value) {
        awake = value;
        return this;
    }

    /** Should this body be prevented from rotating? Useful for characters. **/
    public PhysicsBodyDef fixedRotation(boolean value) {
        fixedRotation = value;
        return this;
    }

    /** Is this a fast moving body that should be prevented from tunneling through other moving bodies? Note that all bodies are
     * prevented from tunneling through kinematic and static bodies. This setting is only considered on dynamic bodies.
     * @warning You should use this flag sparingly since it increases processing time. **/
    public PhysicsBodyDef bullet(boolean value) {
        bullet = value;
        return this;
    }

    /** Does this body start out active? **/
    public PhysicsBodyDef active(boolean value) {
        active = value;
        return this;
    }

    /** Scale the gravity applied to this body. **/
    public PhysicsBodyDef gravityScale(float value) {
        gravityScale = value;
        return this;
    }
}