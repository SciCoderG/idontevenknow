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
	private static float currentTime, startTime, delta;
	
	
	public static void main(String[] args) {
		initDisplay();
		initGL();
		Game.init();
		gameLoop(); // runs, until Display.isCloseRequested() becomes true
		cleanUp();
	}

	private static void cleanUp() {
		Game.clean();
		Display.destroy();
		System.exit(0);
	}

	private static void gameLoop() {
		delta = 1.0f/60.0f;
		
		while (!Display.isCloseRequested()) {
			
			glClear(GL_COLOR_BUFFER_BIT); // no need for depth buffer bit, no depth needed in 2d
			Game.update(delta);
			Game.render();
			Display.update();
			
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
