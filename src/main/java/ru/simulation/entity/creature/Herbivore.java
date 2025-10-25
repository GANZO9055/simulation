package ru.simulation.entity.creature;

import ru.simulation.entity.Grass;
import ru.simulation.map.MapEntity;

import java.util.List;

public class Herbivore extends Creature {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SPEED = 1;

    public Herbivore(Coordinate coordinate) {
        super(DEFAULT_HP, DEFAULT_SPEED, coordinate);
    }

    @Override
    protected Coordinate findTarget(MapEntity map) {
        List<Coordinate> grasses = map.getCoordinatesByType(Grass.class);
        return map.findNearestCoordinate(getCoordinate(), grasses);
    }

    @Override
    protected void performAction(MapEntity map, Coordinate target) {
        map.removeEntity(target);
        setHp(DEFAULT_HP);
    }

    @Override
    public String imageOutputToConsole() {
        return "🐇";
    }
}
