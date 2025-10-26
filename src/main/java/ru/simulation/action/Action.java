package ru.simulation.action;

import ru.simulation.map.WorldMap;

public interface Action {
    void perform(WorldMap map);
}
