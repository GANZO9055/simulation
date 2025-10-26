package ru.simulation.action;

import ru.simulation.game_map.WorldMap;

public class InitializationAction implements Action {
    @Override
    public void perform(WorldMap map) {
        map.createDefaultMap();
    }
}
