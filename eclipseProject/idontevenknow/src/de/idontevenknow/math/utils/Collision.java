package de.idontevenknow.math.utils;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

/**
 * Utility class to check for Collisions. You're welcome to upgrade it!
 * @author David
 *
 */
public class Collision {

    /**
     * Check if point lies within a 2D Box
     * 
     * @param pointX
     *            point position on x axis
     * @param pointY
     *            point position on y axis
     * @param boxPositionX
     *            box position on x axis
     * @param boxPositionY
     *            box position on y axis
     * @param boxWidth
     * @param boxHeight
     * @return
     */
    public static boolean pointOnBoxCollision(float pointX, float pointY,
            float boxPositionX, float boxPositionY, float boxWidth,
            float boxHeight) {
        Vector3 minimum = new Vector3(boxPositionX, boxPositionY, 0);
        Vector3 maximum = new Vector3(boxPositionX + boxWidth, boxPositionY
                + boxHeight, 0);

        BoundingBox box = new BoundingBox(minimum, maximum);

        return box.contains(new Vector3(pointX, pointY, 0));
    }
}
