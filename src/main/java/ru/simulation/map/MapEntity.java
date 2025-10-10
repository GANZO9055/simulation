package ru.simulation.map;

import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Predator;

import java.util.HashMap;
import java.util.Map;

public class MapEntity {
    private final Map<Coordinate, Entity> map = new HashMap<>();

    public void setMap(Coordinate coordinate, Entity entity) {
        map.put(coordinate, entity);
    }

    public void createDefaultMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                setMap(new Coordinate(i, j), new Predator(new Coordinate(i, j)));
            }
        }
    }
}
