package dk.sdu.mmmi.cbse.astroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;

import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * @author jcs
 */
public class AstroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity astroid : world.getEntities(Astroid.class)) {
            PositionPart positionPart = astroid.getPart(PositionPart.class);
            MovingPart movingPart = astroid.getPart(MovingPart.class);
            LifePart lifePart = astroid.getPart(LifePart.class);

            movingPart.setUp(true);
            movingPart.setLeft(new Random().nextInt(10) > 7);


            movingPart.process(gameData, astroid);
            positionPart.process(gameData, astroid);

            updateShape(astroid);
        }
    }

    private void updateShape(Entity entity) {
        Astroid astroid = (Astroid) entity;

        int numPoints = astroid.getPoints();
        float radius = astroid.getRadius();
        float angle = astroid.getAngle() - (float) Math.random() / 100;
        PositionPart positionPart = astroid.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapeX = new float[numPoints], shapeY = new float[numPoints];

        for (int i = 0; i < numPoints; i++) {

            shapeX[i] = x + (float) Math.cos(radians + angle) * radius;
            shapeY[i] = y + (float) Math.sin(radians + angle) * radius;

            angle += (2 * Math.PI / numPoints);
        }

        astroid.setAngle(angle);
        astroid.setShapeX(shapeX);
        astroid.setShapeY(shapeY);
    }

}
