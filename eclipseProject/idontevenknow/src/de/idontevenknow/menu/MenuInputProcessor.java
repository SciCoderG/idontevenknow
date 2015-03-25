package de.idontevenknow.menu;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;

import de.idontevenknow.CompMappers;
import de.idontevenknow.EntityCreator;
import de.idontevenknow.math.utils.Collision;
import de.idontevenknow.physics.components.PositionComponent;

public class MenuInputProcessor implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Buttons.LEFT) {
            return false;
        }
        Family menubuttons = Family.all(MenuButtonComponent.class,
                PositionComponent.class).get();
        ImmutableArray<Entity> entities = EntityCreator.engine
                .getEntitiesFor(menubuttons);

        for (Entity entity : entities) {
            PositionComponent position = CompMappers.position.get(entity);
            MenuButtonComponent menuButton = CompMappers.menuButton.get(entity);

            if (Collision.pointOnBoxCollision(screenX, screenY, position.x,
                    position.y, menuButton.width, menuButton.height)) {
                switch (menuButton.target) {
                case "game":
                    //zum testen
                    MenuEntityCreator.createMenuButton(50, 50,100,100, "main");
                    break;
                case "main":
                    break;
                default:
                    return false;  
                }
            }
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }

}
