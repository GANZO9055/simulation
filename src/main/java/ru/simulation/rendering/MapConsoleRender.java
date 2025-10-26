package ru.simulation.rendering;

import ru.simulation.entity.Entity;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.WorldMap;

import java.util.Map;

public class MapConsoleRender implements Renderer {
    private static final int DEFAULT_SIZE_BY_X = 10;
    private static final int DEFAULT_SIZE_BY_Y = 10;

    public void render(WorldMap map) {
        Map<Coordinate, Entity> entityMap = map.getEntities();
        StringBuilder mapConsole = new StringBuilder();
        PictureFactory pictureFactory = new PictureFactory();
        for (int x = 0; x < DEFAULT_SIZE_BY_X; x++) {
            for (int y = 0; y < DEFAULT_SIZE_BY_Y; y++) {
                mapConsole.append(
                        pictureFactory.getPicture(
                                entityMap.get(new Coordinate(x, y))
                        )
                );
            }
            mapConsole.append("\n");
        }
        clearConsole();
        System.out.println(mapConsole);
    }

    private void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
