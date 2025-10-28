package ru.simulation.action;

import ru.simulation.entity.Entity;
import ru.simulation.game_map.Coordinate;
import ru.simulation.entity.creature.Creature;
import ru.simulation.game_map.WorldMap;

import java.util.Map;

public class MoveAllCreatureAction implements Action {
    @Override
    public void perform(WorldMap map) {
        Map<Coordinate, Entity> entities = map.getEntities();
        for (var entity : entities.entrySet()) {
            if (entity.getValue() instanceof Creature creature) {
                creature.makeMove(map);
            }
        }
    }
}
