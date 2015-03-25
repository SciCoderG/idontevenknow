package de.idontevenknow;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;

import de.idontevenknow.menu.MenuInputProcessor;
import de.idontevenknow.physics.systems.PhysicsSystem;
import de.idontevenknow.physics.systems.UpdatePositionSystem;

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

        // create and add systems
        addSystems();
        //create and add input processors
        setInputProcessors();

    }

    private void addSystems() {
        EntityCreator.engine = engine;
        
        // add PhysicSystem
        PhysicsSystem physicsSystem = new PhysicsSystem(
                GameConstants.BOX2D_VELOCITY_ITERATIONS,
                GameConstants.BOX2D_POSITIONS_ITERATIONS,
                GameConstants.PHYSICS_PRIORITY);
        physicsSystem.setGravity(new Vector2(0,0)); // erstmal keine gravity, brauchen wir in unserem Spiel nicht
        engine.addSystem(physicsSystem);
        EntityCreator.physicsSystem = physicsSystem; 
        
        //add UpdatePositionSystem
        engine.addSystem(new UpdatePositionSystem(GameConstants.PHYSICS_PRIORITY + 1));
        
        
    }
    
    private void setInputProcessors(){
        InputMultiplexer multi = new InputMultiplexer();
        
        MenuInputProcessor menuInput = new MenuInputProcessor();
        multi.addProcessor(menuInput);
        
        Gdx.input.setInputProcessor(multi);
    }

    public PooledEngine getEngine() {
        return engine;
    }

    @Override
    public void dispose() {
        engine.getSystem(PhysicsSystem.class).getWorld().dispose();

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
