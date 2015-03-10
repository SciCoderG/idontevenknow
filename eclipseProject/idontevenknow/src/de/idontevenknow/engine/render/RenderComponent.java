package de.idontevenknow.engine.render;

import org.lwjgl.util.Color;

import de.idontevenknow.engine.Component;

public class RenderComponent extends Component{
	
	Color color;
	
	public RenderComponent(){
		this(new Color(0,0,0,1));
	}
	
	public RenderComponent(Color color){
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
