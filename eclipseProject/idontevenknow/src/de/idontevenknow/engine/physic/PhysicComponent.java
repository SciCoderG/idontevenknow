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
    
    public PhysicComponent(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public PhysicComponent(){
        this(0.0f,0.0f,10,10);
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
