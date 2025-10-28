package ru.simulation.game_map;

import ru.simulation.entity.creature.Creature;

import java.util.List;

public class WorldMapUtils {

    private final WorldMap worldMap;

    public WorldMapUtils(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void moveEntity(Creature entity, Coordinate from, Coordinate to) {
        worldMap.removeEntity(from);
        worldMap.addEntity(to, entity);
    }

    public boolean checkCoordinate(Coordinate coordinate) {
        return (coordinate.x() >= 0 && coordinate.x() < worldMap.getWidth())
                && (coordinate.y() >= 0 && coordinate.y() < worldMap.getHeight());
    }

    public Coordinate findNearestCoordinate(Coordinate from, List<Coordinate> targets) {
        Coordinate nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Coordinate target : targets) {
            int distance = calculationDistance(from, target);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = target;
            }
        }
        return nearest;
    }

    private int calculationDistance(Coordinate from, Coordinate target) {
        return Math.abs(from.x() - target.x()) + Math.abs(from.y() - target.y());
    }
}
