package de.idontevenknow.engine.physic;

import de.idontevenknow.engine.Component;

public class PhysicComponent extends Component{
    //The Position of the collidable physicsbody of a gameobject
    private float x,y;
    
    //The width and height of the physicsbody.
    private float width, height;
    
    //Flag which tells you if there's a collision with another physicsbody
    //at the moment.
    private boolean isCollision = false;
    
    // velocity belongs here, it is a physical component of an object
    private float velocityX;
	private float velocityY;
	private float maxVelocity;
    
    public PhysicComponent(float x, float y, float width, float height, float velocityX, float velocityY, float maxVelocity){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.maxVelocity = maxVelocity;
    }
    
    public PhysicComponent(){
        this(0.0f,0.0f,20,20,50, 50, 100);
    }

    
    
    public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

	public float getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(float maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isCollision() {
        return isCollision;
    }

    public void setCollision(boolean isCollision) {
        this.isCollision = isCollision;
    }
    
}
