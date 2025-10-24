package ru.simulation.action;

import ru.simulation.map.MapEntity;

public class InsertGrassAction implements Action {
    @Override
    public void perform(MapEntity map) {
        map.insertGrass();
    }
}
