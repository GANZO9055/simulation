package ru.simulation.entity.creature;

import ru.simulation.entity.Entity;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.WorldMap;
import ru.simulation.search_path.BFSPathFinder;
import ru.simulation.search_path.PathFinder;

import java.util.List;

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

    public void makeMove(WorldMap map) {

        for (int i = 0; i < speed; i++) {
            Coordinate target = findTarget(map);
            if (target != null && isAdjacent(target)) {
                performAction(map, target);
                return;
            }
            if (target != null) {
                moveTowards(map, target);
            }
        }
    }

    private boolean isAdjacent(Coordinate target) {
        return Math.abs(coordinate.x() - target.x()) + Math.abs(coordinate.y() - target.y()) == 1;
    }

    private void moveTowards(WorldMap map, Coordinate target) {
        PathFinder pathFinder = new BFSPathFinder();
        List<Coordinate> path = pathFinder.findPath(coordinate, target, map, this.getClass());
        if (path.size() > 1) {
            Coordinate next = path.get(1);
            map.moveEntity(this, coordinate, next);
            setCoordinate(next);
        }
    }

    protected abstract Coordinate findTarget(WorldMap map);
    protected abstract void performAction(WorldMap map, Coordinate target);
}
