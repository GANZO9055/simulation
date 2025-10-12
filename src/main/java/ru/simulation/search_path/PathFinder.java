package ru.simulation.search_path;

import ru.simulation.entity.Entity;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.map.MapEntity;

import java.util.List;

public interface PathFinder {
    List<Coordinate> findPath(
            Coordinate start,
            Coordinate target,
            MapEntity map,
            Class<? extends Entity> type
    );
}
