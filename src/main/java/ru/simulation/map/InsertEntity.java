package ru.simulation.map;

import ru.simulation.entity.*;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;

import java.util.Random;

public class InsertEntity {
    public Entity entityGeneration(Coordinate coordinate) {
        Random random = new Random();
        int value = random.nextInt(10);
        return switch (value) {
            case 0 -> new Grass();
            case 1 -> new Rock();
            case 2 -> new Tree();
            case 3 -> new Herbivore(coordinate);
            case 4 -> new Predator(coordinate);
            default -> null;
        };
    }
}
