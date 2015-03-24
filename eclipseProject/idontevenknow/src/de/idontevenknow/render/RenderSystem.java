package de.idontevenknow.render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class RenderSystem extends IteratingSystem{

    public RenderSystem(Family family, int priority) {
        super(family, priority);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        // TODO Auto-generated method stub
        
    }

}
