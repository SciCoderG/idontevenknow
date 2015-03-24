package de.idontevenknow;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Box2D;

/**
 * The Applicationlistener as specified by libgdx.
 * 
 * @author David
 *
 */
public class Game implements ApplicationListener {
    
    private PooledEngine engine;

    @Override
    public void create() {
        // creating the Ashley engine
        engine = new PooledEngine();
        
        // initialise Box2D
        Box2D.init();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {

    }

    @Override
    public void render() {
        engine.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

}
