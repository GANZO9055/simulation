package ru.simulation.map;

import ru.simulation.entity.*;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;

import java.util.Random;

public class InsertEntity {
    public Entity entityGeneration(Coordinate coordinate) {
        Random random = new Random();
        int value = random.nextInt(20);
        return switch (value) {
            case 0, 1 -> new Grass();
            case 2, 3 -> new Rock();
            case 4, 5 -> new Tree();
            case 6, 7 -> new Herbivore(coordinate);
            case 8 -> new Predator(coordinate);
            default -> null;
        };
    }
}
