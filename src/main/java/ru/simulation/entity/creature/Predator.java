package ru.simulation.entity.creature;

import ru.simulation.entity.Entity;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.WorldMap;
import ru.simulation.game_map.WorldMapUtils;

import java.util.List;

public class Predator extends Creature {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SPEED = 1;
    private static final int DEFAULT_ATTACK = 50;

    public Predator(Coordinate coordinate) {
        super(DEFAULT_HP, DEFAULT_SPEED, coordinate);
    }

    @Override
    protected Coordinate findTarget(WorldMap map) {
        WorldMapUtils worldMapUtils = new WorldMapUtils(map);
        List<Coordinate> herbivores = map.getCoordinatesByType(Herbivore.class);
        return worldMapUtils.findNearestCoordinate(getCoordinate(), herbivores);
    }

    @Override
    protected void performAction(WorldMap map, Coordinate target) {
        Entity entity = map.getEntity(target);
        if (entity instanceof Herbivore herbivore) {
            herbivore.setHp(getHp() - DEFAULT_ATTACK);
            if (herbivore.getHp() <= 0) {
                map.removeEntity(target);
            }
        }
    }
}
