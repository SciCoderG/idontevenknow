package de.idontevenknow.game.state;

import de.idontevenknow.engine.physic.PhysicSystem;
import de.idontevenknow.engine.render.RenderSystem;
import de.idontevenknow.game.gameobjects.GameObject;
import de.idontevenknow.game.gameobjects.Player;

public class GamePlayState extends State {

	RenderSystem renderSys;
	PhysicSystem physicSys;
	
	public GamePlayState() {
		super();
	}
	
	@Override
	public void update(float delta) {
		physicSys.update(delta);
		physicSys.run();
	}

	@Override
	public void render() {
		renderSys.run();

	}

	@Override
	public void init() {
		physicSys = new PhysicSystem();
		physicSys.setRegisteredState(this);
		renderSys = new RenderSystem();
		renderSys.setRegisteredState(this);
		objects.add(new Player(10,10,20));
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

}
