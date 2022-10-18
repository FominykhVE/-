import java.io.Serializable;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int health;
    protected int weapons;
    protected int lvl;
    protected double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public int getHealth() {
        return health;
    }

    public int getLvl() {
        return lvl;
    }

    public int getWeapons() {
        return weapons;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}
