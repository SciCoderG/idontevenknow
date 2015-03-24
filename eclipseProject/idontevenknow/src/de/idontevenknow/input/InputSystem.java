package de.idontevenknow.input;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;



public class InputSystem extends IteratingSystem{

    public InputSystem(int priority) {
        super(Family.all(InputComponent.class).get(), priority);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        // TODO Auto-generated method stub
        
    }

}
