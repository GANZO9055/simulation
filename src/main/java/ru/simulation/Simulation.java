package ru.simulation;

import ru.simulation.action.*;
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
                new InsertGrassAction(),
                new InsertHerbivoreAction(),
                new MoveAllCreatureAction()
        );
    }

    public void initialization() {
        actions.get(0).perform(map);
        render.render(map);
    }

    public void nextTurn() {
        checkEntity();
        counterOfMoves++;
        actions.get(3).perform(map);
        render.render(map);
    }

    public void startSimulation(int value) {
        if (value <= 0 || value > 100) {
            System.out.println("Ошибка! Укажите значения от 1 до 100");
            return;
        }
        while(value != 0) {
            checkEntity();
            counterOfMoves++;
            actions.get(3).perform(map);
            render.render(map);
            value--;
        }
    }

    public int getCounterOfMoves() {
        return counterOfMoves;
    }

    private void checkEntity() {
        map.counterGrassAndHerbivore();
        if (counterOfMoves != 0 && checkQuantityGrass()) {
            actions.get(1).perform(map);
        }
        if (counterOfMoves != 0 && checkQuantityHerbivore()) {
            actions.get(2).perform(map);
        }
    }

    private boolean checkQuantityGrass() {
        return map.getCountGrass() <= 2;
    }

    private boolean checkQuantityHerbivore() {
        return map.getCountHerbivore() <= 2;
    }
}
