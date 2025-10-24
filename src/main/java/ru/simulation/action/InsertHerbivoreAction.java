package ru.simulation.action;

import ru.simulation.map.MapEntity;

public class InsertHerbivoreAction implements Action {
    @Override
    public void perform(MapEntity map) {
        map.insertHerbivore();
    }
}
