package ru.simulation.rendering;

import ru.simulation.entity.Entity;
import ru.simulation.entity.Grass;
import ru.simulation.entity.Rock;
import ru.simulation.entity.Tree;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.WorldMap;

import java.util.Map;

public class MapConsoleRender implements Renderer {

    public void render(WorldMap map) {
        Map<Coordinate, Entity> entityMap = map.getEntities();
        StringBuilder mapConsole = new StringBuilder();
        for (int x = 0; x < map.getSizeByX(); x++) {
            for (int y = 0; y < map.getSizeByY(); y++) {
                mapConsole.append(
                        getPicture(
                                entityMap.get(new Coordinate(x, y))
                        )
                );
            }
            mapConsole.append("\n");
        }
        clearConsole();
        System.out.println(mapConsole);
    }

    private String getPicture(Entity entity) {
        String picture;
        if (entity instanceof Grass) {
            picture = "🌾";
        } else if (entity instanceof Rock) {
            picture = "🗻";
        } else if (entity instanceof Tree) {
            picture = "🌳";
        } else if (entity instanceof Herbivore) {
            picture = "🐇";
        } else if (entity instanceof Predator) {
            picture = "🐺";
        } else {
            picture = "🟩";
        }
        return picture;
    }

    private void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
