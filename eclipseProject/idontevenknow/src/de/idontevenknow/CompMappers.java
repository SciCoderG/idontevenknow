package de.idontevenknow;

import com.badlogic.ashley.core.ComponentMapper;

import de.idontevenknow.physics.PhysicsBodyComponent;
import de.idontevenknow.physics.PhysicsModifierComponent;

/**
 * Used to map components to their entities. Always use this to retrieve a
 * Component, using the entity.getComponent(Component.class) runs in O(log n), the
 * ComponentMapper in O(1)
 * 
 * @author David
 *
 */
public class CompMappers {
    public static final ComponentMapper<PhysicsModifierComponent> physicsModifier = ComponentMapper
            .getFor(PhysicsModifierComponent.class);
    public static final ComponentMapper<PhysicsBodyComponent> physicsBody = ComponentMapper
            .getFor(PhysicsBodyComponent.class);
}
