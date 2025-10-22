package ru.simulation.action;

import ru.simulation.map.MapEntity;

public interface Action {
    void perform(MapEntity map);
}
