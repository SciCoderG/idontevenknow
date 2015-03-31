package de.idontevenknow;

import com.badlogic.ashley.core.ComponentMapper;

import de.idontevenknow.input.InputComponent;
import de.idontevenknow.menu.MenuButtonComponent;
import de.idontevenknow.movement.MovementComponent;
import de.idontevenknow.physics.components.PhysicsBodyComponent;
import de.idontevenknow.physics.components.PhysicsModifierComponent;
import de.idontevenknow.physics.components.PositionComponent;

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
    public static final ComponentMapper<PositionComponent> position = ComponentMapper
            .getFor(PositionComponent.class);
    public static final ComponentMapper<MenuButtonComponent> menuButton = ComponentMapper
            .getFor(MenuButtonComponent.class);
    public static final ComponentMapper<InputComponent> input = ComponentMapper
            .getFor(InputComponent.class);
    public static final ComponentMapper<MovementComponent> movement = ComponentMapper
            .getFor(MovementComponent.class);
}
