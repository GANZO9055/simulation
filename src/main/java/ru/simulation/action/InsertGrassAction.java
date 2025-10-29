package ru.simulation.action;

import ru.simulation.entity.Entity;
import ru.simulation.entity.Grass;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.EntityFactory;
import ru.simulation.game_map.GenerationNumber;
import ru.simulation.game_map.WorldMap;

import java.util.Map;

public class InsertGrassAction implements Action {
    @Override
    public void perform(WorldMap map) {
        if (!checkQuantityGrass(map.getEntities())) {
            return;
        }
        insertGrass(map);
    }

    private boolean checkQuantityGrass(Map<Coordinate, Entity> entityMap) {
        int number = counterGrass(entityMap);
        return number <= 2;
    }

    private int counterGrass(Map<Coordinate, Entity> entityMap) {
        int countGrass = 0;
        for(var entity : entityMap.entrySet()) {
           if (entity.getValue() instanceof Grass) {
               countGrass++;
           }
        }
        return countGrass;
    }

    private void insertGrass(WorldMap map) {
        GenerationNumber generationNumber = new GenerationNumber();
        EntityFactory entityFactory = new EntityFactory();
        int quantity = generationNumber.getNumber((map.getWidth() * map.getHeight()) / 10);
        while (quantity != 0) {
            int x = generationNumber.getNumber(map.getWidth());
            int y = generationNumber.getNumber(map.getHeight());
            Coordinate newCoordinate = new Coordinate(x, y);
            Entity newEntity = entityFactory.createGrass();
            if (map.getEntity(newCoordinate) == null) {
                map.addEntity(newCoordinate, newEntity);
                quantity--;
            }
        }
    }
}
