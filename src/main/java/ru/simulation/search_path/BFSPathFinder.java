package ru.simulation.search_path;

import ru.simulation.entity.*;
import ru.simulation.entity.creature.Coordinate;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;
import ru.simulation.map.MapEntity;

import java.util.*;

public class BFSPathFinder implements PathFinder {

    private static final List<Coordinate> DIRECTIONS = List.of(
            new Coordinate(0, 1),
            new Coordinate(-1, 0),
            new Coordinate(0, -1),
            new Coordinate(1, 0)
    );

    @Override
    public List<Coordinate> findPath(Coordinate start,
                                     Coordinate target,
                                     MapEntity map,
                                     Class<? extends Entity> type) {
        Queue<Coordinate> queue = new LinkedList<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();
        Set<Coordinate> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);

        while(!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(target)) {
                List<Coordinate> path = new LinkedList<>();
                while (current != null) {
                    path.add(0, current);
                    current = parentMap.get(current);
                }
                return path;
            }

            for(Coordinate coordinate : DIRECTIONS) {
                Coordinate neighbor = new Coordinate(
                        current.x() + coordinate.x(),
                        current.y() + coordinate.y()
                );
                if (!visited.contains(neighbor) && isValid(neighbor, map, type)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        return List.of();
    }

    private boolean isValid(Coordinate coordinate, MapEntity map, Class<? extends Entity> type) {

        if (!map.checkCoordinate(coordinate)) {
            return false;
        }

        Entity entity = map.getEntity(coordinate);

        if (entity == null) {
            return true;
        }
        if (entity instanceof Rock || entity instanceof Tree) {
            return false;
        }
        if (type == Herbivore.class) {
            return entity instanceof Grass;
        }
        if (type == Predator.class) {
            return entity instanceof Herbivore;
        }
        return false;
    }
}
