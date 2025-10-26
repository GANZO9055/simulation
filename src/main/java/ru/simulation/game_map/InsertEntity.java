package ru.simulation.game_map;

import ru.simulation.entity.*;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;

public class InsertEntity {
    private final GenerationNumber generationNumber;

    public InsertEntity() {
        this.generationNumber = new GenerationNumber();
    }

    public Entity entityGeneration(Coordinate coordinate) {
        int value = generationNumber.getNumber(20);
        return switch (value) {
            case 0, 1 -> new Grass();
            case 2, 3 -> new Rock();
            case 4, 5 -> new Tree();
            case 6, 7 -> new Herbivore(coordinate);
            case 8 -> new Predator(coordinate);
            default -> null;
        };
    }

    public Entity grassGeneration() {
        return new Grass();
    }

    public Entity herbivoreGeneration(Coordinate coordinate) {
        return new Herbivore(coordinate);
    }
}
