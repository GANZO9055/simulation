package ru.simulation.action;

import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.EntityFactory;
import ru.simulation.game_map.WorldMap;

public class InitializationAction implements Action {
    @Override
    public void perform(WorldMap map) {
        EntityFactory entityFactory = new EntityFactory();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                map.addEntity(
                        new Coordinate(x, y),
                        entityFactory.createEntity(new Coordinate(x, y))
                );
            }
        }
    }
}
