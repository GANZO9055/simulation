package ru.simulation.action;

import ru.simulation.entity.Entity;
import ru.simulation.map.Coordinate;
import ru.simulation.entity.creature.Creature;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;
import ru.simulation.map.WorldMap;

import java.util.Map;

public class MoveAllCreatureAction implements Action {
    @Override
    public void perform(WorldMap map) {
        Map<Coordinate, Entity> map1 = map.getMap();
        for (var entity : map1.entrySet()) {
            if (entity.getValue() instanceof Predator || entity.getValue() instanceof Herbivore) {
                ((Creature) entity.getValue()).makeMove(map);
            }
        }
    }
}
