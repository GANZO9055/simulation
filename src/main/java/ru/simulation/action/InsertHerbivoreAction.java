package ru.simulation.action;

import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.EntityFactory;
import ru.simulation.game_map.GenerationNumber;
import ru.simulation.game_map.WorldMap;

import java.util.Map;

public class InsertHerbivoreAction implements Action {
    @Override
    public void perform(WorldMap map) {
        if (!checkQuantityHerbivore(map.getEntities())) {
            return;
        }
        insertHerbivore(map);
    }

    private boolean checkQuantityHerbivore(Map<Coordinate, Entity> entityMap) {
        int number = counterHerbivore(entityMap);
        return number <= 2;
    }

    private int counterHerbivore(Map<Coordinate, Entity> entityMap) {
        int countHerbivore = 0;
        for(var entity : entityMap.entrySet()) {
            if (entity.getValue() instanceof Herbivore) {
                countHerbivore++;
            }
        }
        return countHerbivore;
    }

    private void insertHerbivore(WorldMap map) {
        GenerationNumber generationNumber = new GenerationNumber();
        EntityFactory entityFactory = new EntityFactory();
        int quantity = generationNumber.getNumber((map.getWidth() * map.getHeight()) / 10);
        while (quantity != 0) {
            int x = generationNumber.getNumber(map.getWidth());
            int y = generationNumber.getNumber(map.getHeight());
            Coordinate newCoordinate = new Coordinate(x, y);
            Entity newEntity = entityFactory.herbivoreGeneration(newCoordinate);
            if (map.getEntity(newCoordinate) == null) {
                map.addEntity(newCoordinate, newEntity);
                quantity--;
            }
        }
    }
}
