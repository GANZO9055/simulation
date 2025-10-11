package ru.simulation.map;

import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Coordinate;

import java.util.Map;

public class MapConsoleRender {
    MapEntity map = new MapEntity();

    public void render() {
        map.createDefaultMap();
        Map<Coordinate, Entity> entityMap = map.getMap();
        StringBuilder mapConsole = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapConsole.append(entityMap.get(new Coordinate(i, j)).imageOutputToConsole());
            }
            mapConsole.append("\n");
        }
        System.out.println(mapConsole);
    }
}
