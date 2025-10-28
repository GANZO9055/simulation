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
    private static final int QUANTITY_ENTITY = 10;
    private final Map<Coordinate, Entity> entities = new HashMap<>();
    private final EntityFactory entityFactory = new EntityFactory();
    private final GenerationNumber generationNumber = new GenerationNumber();
    private int countGrass = 0;
    private int countHerbivore = 0;

    private final int sizeByX;
    private final int sizeByY;

    public WorldMap(int sizeByX, int sizeByY) {
        this.sizeByX = sizeByX;
        this.sizeByY = sizeByY;
    }

    public int getSizeByX() {
        return sizeByX;
    }

    public int getSizeByY() {
        return sizeByY;
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

    public void createMap() {
        for (int x = 0; x < getSizeByX(); x++) {
            for (int y = 0; y < getSizeByY(); y++) {
                addEntity(
                        new Coordinate(x, y),
                        entityFactory.entityGeneration(new Coordinate(x, y))
                );
            }
        }
    }



    public int getCountGrass() {
        return countGrass;
    }

    public int getCountHerbivore() {
        return countHerbivore;
    }

    public void counterGrassAndHerbivore() {
        countGrass = 0;
        countHerbivore = 0;
        for (int x = 0; x < getSizeByX(); x++) {
            for (int y = 0; y < getSizeByY(); y++) {
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
        return (coordinate.x() >= 0 && coordinate.x() < getSizeByX())
                && (coordinate.y() >= 0 && coordinate.y() < getSizeByY());
    }

    public void moveEntity(Creature entity, Coordinate from, Coordinate to) {
        removeEntity(from);
        addEntity(to, entity);
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
            int x = generationNumber.getNumber(getSizeByX());
            int y = generationNumber.getNumber(getSizeByY());
            Coordinate newCoordinate = new Coordinate(x, y);
            Entity newEntity = number == 1 ? entityFactory.grassGeneration()
                    : entityFactory.herbivoreGeneration(newCoordinate);
            if (getEntity(newCoordinate) == null) {
                addEntity(newCoordinate, newEntity);
                quantity--;
            }
        }
    }
}
