package ru.simulation.rendering;

import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.map.MapEntity;

import java.util.Map;

public class MapConsoleRender implements Render {
    MapEntity map = new MapEntity();

    public void render() {
        map.createDefaultMap();
        Map<Coordinate, Entity> entityMap = map.getMap();
        StringBuilder mapConsole = new StringBuilder();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                mapConsole.append(entityMap.get(new Coordinate(x, y)).imageOutputToConsole());
            }
            mapConsole.append("\n");
        }
        System.out.println(mapConsole);
    }
}
