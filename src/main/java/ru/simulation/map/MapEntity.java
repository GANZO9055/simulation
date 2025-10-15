package ru.simulation.map;

import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEntity {
    private static final int DEFAULT_SIZE_BY_X = 10;
    private static final int DEFAULT_SIZE_BY_Y = 10;
    private final Map<Coordinate, Entity> map = new HashMap<>();
    private final InsertEntity insertEntity = new InsertEntity();

    public void addEntity(Coordinate coordinate, Entity entity) {
        map.put(coordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public void removeEntity(Coordinate coordinate) {
        map.remove(coordinate);
    }

    public Map<Coordinate, Entity> getMap() {
        return new HashMap<>(map);
    }

    public void createDefaultMap() {
        for (int x = 0; x < DEFAULT_SIZE_BY_X; x++) {
            for (int y = 0; y < DEFAULT_SIZE_BY_Y; y++) {
                addEntity(
                        new Coordinate(x, y),
                        insertEntity.entityGeneration(new Coordinate(x, y))
                );
            }
        }
    }

    public boolean checkCoordinate(Coordinate coordinate) {
        return (coordinate.x() >= 0 && coordinate.x() < DEFAULT_SIZE_BY_X)
                && (coordinate.y() >= 0 && coordinate.y() < DEFAULT_SIZE_BY_Y);
    }

    public void moveEntity(Creature entity, Coordinate from, Coordinate to) {
        map.remove(from);
        map.put(to, entity);
    }

    public <T extends Entity> List<Coordinate> getCoordinatesByType(Class<T> type) {
        List<Coordinate> result = new ArrayList<>();
        for (var value : map.entrySet()) {
            if (type.isInstance(value.getValue())) {
                result.add(value.getKey());
            }
        }
        return result;
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
