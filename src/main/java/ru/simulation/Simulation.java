package ru.simulation;

import ru.simulation.action.Action;
import ru.simulation.action.InitializationAction;
import ru.simulation.action.MoveAllCreatureAction;
import ru.simulation.map.MapEntity;
import ru.simulation.rendering.MapConsoleRender;
import ru.simulation.rendering.Render;

import java.util.List;

public class Simulation {
    private final MapEntity map;
    private int counterOfMoves;
    private final Render render;
    private final List<Action> actions;

    public Simulation() {
        this.map = new MapEntity();
        this.counterOfMoves = 0;
        this.render = new MapConsoleRender();
        this.actions = List.of(
                new InitializationAction(),
                new MoveAllCreatureAction()
        );
    }

    public void initialization() {
        actions.get(0).perform(map);
        render.render(map);
    }

    public void nextTurn() {
        counterOfMoves++;
        actions.get(1).perform(map);
        render.render(map);
    }

    public void startSimulation(int value) {
        while(value != 0) {
            counterOfMoves++;
            actions.get(1).perform(map);
            render.render(map);
            value--;
        }
    }

    public int getCounterOfMoves() {
        return counterOfMoves;
    }
}
