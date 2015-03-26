package de.idontevenknow.menu;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import de.idontevenknow.EntityCreator;
import de.idontevenknow.physics.components.PhysicsBodyComponent;
import de.idontevenknow.physics.components.PositionComponent;
import de.idontevenknow.physics.utils.PhysicsBodyDef;
import de.idontevenknow.physics.utils.PhysicsFixtureDef;

/**
 * Used to load the menu entities (like buttons, background etc.)
 * 
 * @author David Liebemann
 *
 */
public class MenuEntityCreator extends EntityCreator {

    /**
     * Creates the MainMenu
     * 
     * @return List of Entities created
     */
    public static List<Entity> createMainMenu() {
        List<Entity> toReturn = new ArrayList<Entity>();
        float width = 300.0f;
        float height = 100.0f;

        float x = Gdx.graphics.getWidth() / 2;
        float y = Gdx.graphics.getHeight() / 2;

        Entity entity = createMenuButton(x, y, width, height, "game");
        toReturn.add(entity);

        return toReturn;
    }

    /**
     * Creates a Menu Button. Use World Coordinates, not Box2D coordinates!
     * 
     * @param x center position on x axis
     * @param y center position on y axis
     * @param width
     * @param height
     * @param target
     * @return created entity
     */
    public static Entity createMenuButton(float x, float y, float width,
            float height, String target) {
        Entity entity = engine.createEntity();

        // physicsbody definition - this wont be needed anymore, once the
        // RenderingSystem has been initiated
        PhysicsBodyComponent bodyComponent = engine
                .createComponent(PhysicsBodyComponent.class);

        PhysicsBodyDef bodyDef = new PhysicsBodyDef(BodyType.KinematicBody,
                physicsSystem).position(x, y).fixedRotation(true);
        bodyComponent.init(bodyDef, physicsSystem, entity);

        PhysicsFixtureDef fixtureDef = new PhysicsFixtureDef(physicsSystem)
                .shapeBox(width, height);
        bodyComponent.createFixture(fixtureDef);

        entity.add(bodyComponent);

        // position component
        entity.add(engine.createComponent(PositionComponent.class));

        // menubuttonComponent
        MenuButtonComponent menuButton = engine
                .createComponent(MenuButtonComponent.class);
        menuButton.width = width;
        menuButton.height = height;
        menuButton.buttonText = "Game";
        menuButton.target = target;
        entity.add(menuButton);

        //
        engine.addEntity(entity);
        return entity;
    }

}
