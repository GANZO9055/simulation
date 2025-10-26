package ru.simulation.action;

import ru.simulation.map.WorldMap;

public class InitializationAction implements Action {
    @Override
    public void perform(WorldMap map) {
        map.createDefaultMap();
    }
}
