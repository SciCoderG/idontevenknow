package de.idontevenknow.physics.utils;

import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import de.idontevenknow.math.utils.Point;
import de.idontevenknow.physics.systems.PhysicsSystem;


/**
* Nearly the same helper class as PhysixFixtureDef of the gdw-commons-gdx
* Easier to use FixtureDefinition of a Box2D fixture
*
* @author David Liebemann
* @author Santo Pfingsten
*/
public class PhysicsFixtureDef extends FixtureDef {

   private static final Vector2 dummyVector = new Vector2();

   private final PhysicsSystem system;

   
   public PhysicsFixtureDef(PhysicsSystem system) {
       this.system = system;
   }

   /** The friction coefficient, usually in the range [0,1]. **/
   public PhysicsFixtureDef friction(float value) {
       friction = value;
       return this;
   }

   /** The restitution (elasticity) usually in the range [0,1]. **/
   public PhysicsFixtureDef restitution(float value) {
       restitution = value;
       return this;
   }

   /** The density, usually in kg/m^2. **/
   public PhysicsFixtureDef density(float value) {
       density = value;
       return this;
   }

   /** A sensor shape collects contact information but never generates a collision response. */
   public PhysicsFixtureDef sensor(boolean value) {
       isSensor = value;
       return this;
   }

   /** The collision category bits. Normally you would just set one bit. */
   public PhysicsFixtureDef category(short bits) {
       filter.categoryBits = bits;
       return this;
   }

   /** The collision mask bits. This states the categories that this shape would accept for collision. */
   public PhysicsFixtureDef mask(short bits) {
       filter.maskBits = bits;
       return this;
   }

   /** Collision groups allow a certain group of objects to never collide (negative) or always collide (positive). Zero means no
    * collision group. Non-zero group filtering always wins against the mask bits. */
   public PhysicsFixtureDef groupIndex(short bits) {
       filter.groupIndex = bits;
       return this;
   }

   /**
    * Gives the fixture a box shape. Important, the 
    * @param width
    * @param height
    * @return
    */
   public PhysicsFixtureDef shapeBox(float width, float height) {
       return shapeBox(width, height, Vector2.Zero, 0);
   }

   /**
    * Gives the fixture a box shape and rotation around a given center
    * @param width
    * @param height
    * @param center of the box in world coordinates
    * @param angle rotation in radians of the box
    * @return
    */
   public PhysicsFixtureDef shapeBox(float width, float height, Vector2 center, float angle) {
       float halfWidth = system.toBox2D(width) * 0.5f;
       float halfHeight = system.toBox2D(height) * 0.5f;

       PolygonShape polyShape = new PolygonShape();
       polyShape.setAsBox(halfWidth, halfHeight, system.toBox2D(center, dummyVector), angle);
       this.shape = polyShape;
       return this;
   }

   public PhysicsFixtureDef shapeCircle(float radius) {
       return shapeCircle(radius, Vector2.Zero);
   }

   public PhysicsFixtureDef shapeCircle(float radius, Vector2 center) {
       radius = system.toBox2D(radius);
       CircleShape circleShape = new CircleShape();
       circleShape.setRadius(radius);
       circleShape.setPosition(system.toBox2D(center, dummyVector));
       this.shape = circleShape;
       return this;
   }

   /**
    * Gives the fixture a polygon shape
    * @param points
    * @return
    */
   public PhysicsFixtureDef shapePolygon(List<Point> points) {
       PolygonShape polyShape = new PolygonShape();
       polyShape.set(system.toBox2D(points));
       this.shape = polyShape;
       return this;
   }

   /**
    * Gives the fixture a Chain Shape (Polyline)
    * @param points
    * @return
    */
   public PhysicsFixtureDef shapePolyline(List<Point> points) {
       ChainShape chainShape = new ChainShape();
       chainShape.createChain(system.toBox2D(points));
       this.shape = chainShape;
       return this;
   }
}
