package ru.simulation.entity.creature;

import ru.simulation.entity.Entity;
import ru.simulation.search_path.BFSPathFinder;
import ru.simulation.search_path.PathFinder;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;
    private Coordinate coordinate;


    public Creature(int speed, int hp, Coordinate coordinate) {
        this.speed = speed;
        this.hp = hp;
        this.coordinate = coordinate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void makeMove() {
        PathFinder searchPath = new BFSPathFinder();

    };
}
