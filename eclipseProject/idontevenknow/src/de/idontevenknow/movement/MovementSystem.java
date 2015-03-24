package de.idontevenknow.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;


public class MovementSystem extends IteratingSystem{

    public MovementSystem(int priority) {
        super(Family.all(MovementComponent.class).get(), priority);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        // TODO Auto-generated method stub
        
    }

    

}
