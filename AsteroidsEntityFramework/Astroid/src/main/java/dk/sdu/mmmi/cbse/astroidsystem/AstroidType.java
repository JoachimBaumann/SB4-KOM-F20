package dk.sdu.mmmi.cbse.astroidsystem;

public enum AstroidType {
    LARGE(8,25,10f, 8),
    MEDIUM(6,10,25f, 3),
    SMALL(3,5,50f, 1);

    private final int points;
    private final int size;
    private final float speed;
    private final int life;

    AstroidType(int points, int size, float speed, int life) {
        this.points = points;
        this.size = size;
        this.speed = (float) Math.random() * 10f + speed;
        this.life = life;
    }

    public int getPoints() {
        return points;
    }

    public int getSize() {
        return size;
    }

    public float getSpeed() {
        return speed;
    }

    public int getLife() {
        return life;
    }
}