package ru.simulation.action;

import ru.simulation.game_map.WorldMap;

public class InsertHerbivoreAction implements Action {
    @Override
    public void perform(WorldMap map) {
        if (!checkQuantityHerbivore(map)) {
            return;
        }
        map.insertHerbivore();
    }

    private boolean checkQuantityHerbivore(WorldMap map) {
        map.counterGrassAndHerbivore();
        return map.getCountHerbivore() <= 2;
    }
}
