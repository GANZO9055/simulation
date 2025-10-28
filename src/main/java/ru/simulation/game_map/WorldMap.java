package ru.simulation.game_map;

import ru.simulation.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private final Map<Coordinate, Entity> entities = new HashMap<>();

    private final int width;
    private final int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }

    public void removeEntity(Coordinate coordinate) {
        entities.remove(coordinate);
    }

    public Map<Coordinate, Entity> getEntities() {
        return new HashMap<>(entities);
    }

    public <T extends Entity> List<Coordinate> getCoordinatesByType(Class<T> type) {
        List<Coordinate> result = new ArrayList<>();
        for (var value : entities.entrySet()) {
            if (type.isInstance(value.getValue())) {
                result.add(value.getKey());
            }
        }
        return result;
    }
}
