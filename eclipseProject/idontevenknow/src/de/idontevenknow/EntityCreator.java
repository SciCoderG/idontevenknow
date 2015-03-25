package de.idontevenknow;

import com.badlogic.ashley.core.PooledEngine;

import de.idontevenknow.physics.systems.PhysicsSystem;

public abstract class EntityCreator {
    public static PooledEngine engine;
    public static PhysicsSystem physicsSystem; 
}
