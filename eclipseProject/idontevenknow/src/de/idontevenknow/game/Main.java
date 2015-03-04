package de.idontevenknow.game;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main {
	public static void main(String[] args) {
		try{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("idontevenknow");
			Display.create();
		} 
		catch(LWJGLException e){
			System.out.println(e.getMessage());
			System.exit(1);	
		}
		
		while(!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			Display.update();
		}
	
		Display.destroy();
		System.exit(0);
		
	}
}
