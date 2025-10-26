package ru.simulation.game_map;

import ru.simulation.entity.Grass;
import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Creature;
import ru.simulation.entity.creature.Herbivore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private static final int DEFAULT_SIZE_BY_X = 10;
    private static final int DEFAULT_SIZE_BY_Y = 10;
    private static final int QUANTITY_ENTITY = 10;
    private final Map<Coordinate, Entity> entities = new HashMap<>();
    private final InsertEntity insertEntity = new InsertEntity();
    private final GenerationNumber generationNumber = new GenerationNumber();
    private int countGrass = 0;
    private int countHerbivore = 0;

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

    public int getCountGrass() {
        return countGrass;
    }

    public int getCountHerbivore() {
        return countHerbivore;
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

    public void counterGrassAndHerbivore() {
        countGrass = 0;
        countHerbivore = 0;
        for (int x = 0; x < DEFAULT_SIZE_BY_X; x++) {
            for (int y = 0; y < DEFAULT_SIZE_BY_Y; y++) {
                Entity entity = getEntity(new Coordinate(x,y));
                if (entity instanceof Grass) {
                    countGrass++;
                }
                if (entity instanceof Herbivore) {
                    countHerbivore++;
                }
            }
        }
    }

    public void insertGrass() {
        insertGrassOrHerbivore(1);
    }

    public void insertHerbivore() {
        insertGrassOrHerbivore(2);
    }

    public boolean checkCoordinate(Coordinate coordinate) {
        return (coordinate.x() >= 0 && coordinate.x() < DEFAULT_SIZE_BY_X)
                && (coordinate.y() >= 0 && coordinate.y() < DEFAULT_SIZE_BY_Y);
    }

    public void moveEntity(Creature entity, Coordinate from, Coordinate to) {
        removeEntity(from);
        addEntity(to, entity);
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

    private void insertGrassOrHerbivore(int number) {
        int quantity = generationNumber.getNumber(QUANTITY_ENTITY);
        while (quantity != 0) {
            int x = generationNumber.getNumber(DEFAULT_SIZE_BY_X);
            int y = generationNumber.getNumber(DEFAULT_SIZE_BY_Y);
            Coordinate newCoordinate = new Coordinate(x, y);
            Entity newEntity = number == 1 ? insertEntity.grassGeneration()
                    : insertEntity.herbivoreGeneration(newCoordinate);
            if (getEntity(newCoordinate) == null) {
                addEntity(newCoordinate, newEntity);
                quantity--;
            }
        }
    }
}
