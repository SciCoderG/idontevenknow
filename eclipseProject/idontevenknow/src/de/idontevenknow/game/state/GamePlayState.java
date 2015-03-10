package de.idontevenknow.game.state;

import de.idontevenknow.engine.physic.PhysicSystem;
import de.idontevenknow.engine.render.RenderSystem;
import de.idontevenknow.game.gameobjects.GameObject;
import de.idontevenknow.game.gameobjects.Player;

public class GamePlayState extends State {

	RenderSystem renderSys;
	PhysicSystem physicSys;

	@Override
	public void update() {
		for (GameObject i : objects) {

		}

	}

	@Override
	public void render() {
		for(GameObject i : objects){
			
		}

	}

	@Override
	public void init() {
		physicSys = new PhysicSystem();
		renderSys = new RenderSystem();
		objects.add(new Player());
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

}
