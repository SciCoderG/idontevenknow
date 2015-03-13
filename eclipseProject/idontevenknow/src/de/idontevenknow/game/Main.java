package de.idontevenknow.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * Initialises OpenGL and the LWJGL Display
 * @author David
 *
 */
public class Main {
	private static float currentTime, startTime;
	private static int fps = 60;
	private static float delta = 1.0f/(float)fps;
	private static Game game;
	
	
	public static void main(String[] args) {
		initDisplay();
		initGL();
		game = new Game();
		game.init();
		gameLoop(); // runs, until Display.isCloseRequested() becomes true
		cleanUp();
	}

	private static void cleanUp() {
		game.clean();
		Display.destroy();
		System.exit(0);
	}

	private static void gameLoop() {
		delta = 1.0f/(float)fps;
		startTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis();
		
		while (!Display.isCloseRequested()) {
			if(currentTime-startTime > delta){
				delta += currentTime-startTime -delta;
			}
			startTime = System.currentTimeMillis();
			glClear(GL_COLOR_BUFFER_BIT); // no need for depth buffer bit, no depth needed in 2d
			game.update(delta);
			game.render();
			Display.update();
			currentTime = System.currentTimeMillis();
			Display.sync(fps); // THIS IS WHERE THE CAPPING OF THE FPS HAPPENS (aka the system is
			// put to sleep, if it is done with the loop faster than the framerate commands
		}
	}

	private static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0,Display.getHeight(), -1, 1); // set the view in the beginning correctly
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(1, 1, 1, 1);
		
		glDisable(GL_DEPTH_TEST); // not needed in 2d
		
	}

	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("idontevenknow");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
