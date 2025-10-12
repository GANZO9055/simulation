package ru.simulation.rendering;

import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.map.MapEntity;

import java.util.Map;

public class MapConsoleRender implements Render {
    private static final int DEFAULT_SIZE_BY_X = 10;
    private static final int DEFAULT_SIZE_BY_Y = 10;
    MapEntity map = new MapEntity();

    public void render() {
        map.createDefaultMap();
        Map<Coordinate, Entity> entityMap = map.getMap();
        StringBuilder mapConsole = new StringBuilder();
        for (int x = 0; x < DEFAULT_SIZE_BY_X; x++) {
            for (int y = 0; y < DEFAULT_SIZE_BY_Y; y++) {
                if(entityMap.get(new Coordinate(x,y)) == null) {
                    mapConsole.append("🟩");
                    continue;
                }
                mapConsole.append(entityMap.get(new Coordinate(x, y)).imageOutputToConsole());
            }
            mapConsole.append("\n");
        }
        System.out.println(mapConsole);
    }
}
