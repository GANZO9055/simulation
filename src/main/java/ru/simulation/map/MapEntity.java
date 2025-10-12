package ru.simulation.map;

import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class MapEntity {
    private static final int DEFAULT_SIZE_BY_X = 10;
    private static final int DEFAULT_SIZE_BY_Y = 10;
    private final Map<Coordinate, Entity> map = new HashMap<>();
    private final InsertEntity insertEntity = new InsertEntity();

    public void setMap(Coordinate coordinate, Entity entity) {
        map.put(coordinate, entity);
    }

    public Map<Coordinate, Entity> getMap() {
        return new HashMap<>(map);
    }

    public void createDefaultMap() {
        for (int x = 0; x < DEFAULT_SIZE_BY_X; x++) {
            for (int y = 0; y < DEFAULT_SIZE_BY_Y; y++) {
                setMap(
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

    public Entity getEntity(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public void singleMoveCreature() {

    }

    public void multipleCreatureMoves() {

    }
}
