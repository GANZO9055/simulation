package ru.simulation.action;

import ru.simulation.game_map.WorldMap;

public interface Action {
    void perform(WorldMap map);
}
