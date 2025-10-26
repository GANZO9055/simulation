package ru.simulation.search_path;

import ru.simulation.entity.Entity;
import ru.simulation.game_map.Coordinate;
import ru.simulation.game_map.WorldMap;

import java.util.List;

public interface PathFinder {
    List<Coordinate> findPath(
            Coordinate start,
            Coordinate target,
            WorldMap map,
            Class<? extends Entity> type
    );
}
