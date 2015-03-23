package de.idontevenknow.engine.render;


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
		
	}
	
	
	
}
