package dk.sdu.mmmi.cbse.astroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

import static java.lang.Math.PI;

public class AstroidPlugin implements IGamePluginService {

    private Entity astroid;

    public AstroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        astroid = createAsteroid(gameData);
        world.addEntity(astroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float radians = (float) PI / 2 + (float) Math.random();
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();

        int radNum = new Random().nextInt(150) % 3; // get random number between 0 and 2

        Astroid asteroid = new Astroid(AstroidType.values()[radNum]);

        asteroid.setRadius(asteroid.getSize());
        asteroid.add(new MovingPart(0, asteroid.getSpeed(), asteroid.getSpeed(), 0));
        asteroid.add(new PositionPart(x, y, radians));

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(astroid);
    }

}
