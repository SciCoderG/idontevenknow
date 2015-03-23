package de.idontevenknow;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Initialises the LwjglApplication with the given parameters Parameters can
 * later be read out of a config fileO
 * 
 * @author David
 *
 */
public class Main {

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "WeReallyDontKnow";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new Game(), config);
    }

}
