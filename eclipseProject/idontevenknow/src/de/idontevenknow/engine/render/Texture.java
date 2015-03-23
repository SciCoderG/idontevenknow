package de.idontevenknow.engine.render;

import static org.lwjgl.opengl.GL11.*;

public class Texture {

	private int target;		// GL Target Type 
	private int textureID;	//GL TextureID
	private int width;		// image width
	private int height;		//image height
	
	private int textureWidht;	//texture widht
	private int textureHeight;	//texture height
	
	public Texture(int target, int textureID){	//Konstructor ,create a new Texture
		this.target=target;
		this.textureID=textureID;
	}
	
	public void glbind(){
		glBindTexture(target, textureID); //bind GL Context to Texture
		
	}
	
	
	
}
