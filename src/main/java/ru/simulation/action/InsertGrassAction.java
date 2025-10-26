package ru.simulation.action;

import ru.simulation.game_map.WorldMap;

public class InsertGrassAction implements Action {
    @Override
    public void perform(WorldMap map) {
        if (!checkQuantityGrass(map)) {
            return;
        }
        map.insertGrass();
    }

    private boolean checkQuantityGrass(WorldMap map) {
        map.counterGrassAndHerbivore();
        return map.getCountGrass() <= 2;
    }
}
