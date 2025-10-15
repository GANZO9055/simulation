package ru.simulation.entity.creature;

import ru.simulation.entity.Entity;
import ru.simulation.map.MapEntity;

import java.util.List;

public class Predator extends Creature {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SPEED = 3;
    private static final int DEFAULT_ATTACK = 50;

    public Predator(Coordinate coordinate) {
        super(DEFAULT_HP, DEFAULT_SPEED, coordinate);
    }

    @Override
    protected Coordinate findTarget(MapEntity map) {
        List<Coordinate> herbivores = map.getCoordinatesByType(Herbivore.class);
        return map.findNearestCoordinate(getCoordinate(), herbivores);
    }

    @Override
    protected void performAction(MapEntity map, Coordinate target) {
        Entity entity = map.getEntity(target);
        if (entity instanceof Herbivore herbivore) {
            herbivore.setHp(getHp() - DEFAULT_ATTACK);
            if (herbivore.getHp() <= 0) {
                map.removeEntity(target);
            }
        }
    }

    @Override
    public String imageOutputToConsole() {
        return "🐺";
    }
}
