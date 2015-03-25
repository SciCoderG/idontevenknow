package de.idontevenknow.menu;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import de.idontevenknow.EntityCreator;
import de.idontevenknow.physics.components.PhysicsBodyComponent;
import de.idontevenknow.physics.components.PositionComponent;

/**
 * Used to load the menu entities (like buttons, background etc.)
 * 
 * @author David
 *
 */
public class MenuEntityCreator extends EntityCreator{

    public static Entity createMenuButton(float x, float y, float width, float height, String target){
        Entity entity = engine.createEntity();

        
        //physicsbody definition
        PhysicsBodyComponent bodyComponent = engine.createComponent(PhysicsBodyComponent.class);
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x / physicsSystem.getScale(), y / physicsSystem.getScale());
        bodyDef.type = BodyType.KinematicBody;
        bodyComponent.init(bodyDef, physicsSystem, entity);
        
        PolygonShape box = new PolygonShape();
        box.setAsBox(width / physicsSystem.getScale()  , height / physicsSystem.getScale());
        
        bodyComponent.getBody().createFixture(box, 0);
        
        box.dispose();
        entity.add(bodyComponent);
        
        // position component
        entity.add(engine.createComponent(PositionComponent.class));
        
        //menubuttonComponent
        MenuButtonComponent menuButton = engine.createComponent(MenuButtonComponent.class);
        menuButton.width = width;
        menuButton.height = height;
        menuButton.buttonText = "Game";
        menuButton.target = target;
        entity.add(menuButton);
        
        engine.addEntity(entity);
        return entity;
    }
    
}
