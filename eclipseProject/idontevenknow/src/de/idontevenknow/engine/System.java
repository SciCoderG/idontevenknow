package de.idontevenknow.engine;

import de.idontevenknow.game.state.State;

/**
 * Abstract model of every System in the game
 * bspw.: Render, Physic, Sound etc.
 * @author David
 *
 */
public abstract class System {
	protected State registeredState;
	
	

	public State getRegisteredState() {
		return registeredState;
	}

	public void setRegisteredState(State registeredState) {
		this.registeredState = registeredState;
	}
	
	/**
	 * always called
	 */
	public abstract void run();
}
