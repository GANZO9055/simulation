package ru.simulation.game_map;

import ru.simulation.entity.*;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;

public class EntityFactory {
    private final static int MAXIMUM_PROBABILITY = 20;
    private final GenerationNumber generationNumber;

    public EntityFactory() {
        this.generationNumber = new GenerationNumber();
    }

    public Entity createEntity(Coordinate coordinate) {
        int value = generationNumber.getNumber(MAXIMUM_PROBABILITY);
        return switch (value) {
            case 0, 1 -> new Grass(); // 0, 1 - 10% вероятность появления
            case 2, 3 -> new Rock(); // 2, 3 - 10%
            case 4, 5 -> new Tree(); // 4, 5 - 10%
            case 6, 7 -> new Herbivore(coordinate); // 6, 7 - 10%
            case 8 -> new Predator(coordinate); // 8 - 5%
            default -> null; // 55%
        };
    }

    public Entity createGrass() {
        return new Grass();
    }

    public Entity createHerbivore(Coordinate coordinate) {
        return new Herbivore(coordinate);
    }
}
