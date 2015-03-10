package de.idontevenknow.game;

import java.util.Stack;

import de.idontevenknow.game.state.GamePlayState;
import de.idontevenknow.game.state.State;


public class Game {
	
	private static Stack<State> states;
		
	/**
	 * TODO
	 */
	public void init(){
		states = new Stack<State>();
		states.push(new GamePlayState());
	}
	
	// TODO
	public void update(float delta){
		states.firstElement().update(delta);
	}
	
	//TODO
	public void render(){
		states.firstElement().render();
	}
	
	//TODO
	public void clean(){
		
	}
}
