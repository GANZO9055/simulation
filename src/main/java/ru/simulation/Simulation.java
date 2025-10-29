package ru.simulation;

import ru.simulation.action.*;
import ru.simulation.action.Action;
import ru.simulation.game_map.WorldMap;
import ru.simulation.rendering.Renderer;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    private static final int STOP_SIMULATION = 1;

    private final WorldMap map;
    private int counterOfMoves;
    private final Renderer render;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(WorldMap map, Renderer render) {
        this.map = map;
        this.render = render;
        this.counterOfMoves = 0;
        this.initActions = List.of(
                new InitializationAction()
        );
        this.turnActions = List.of(
                new InsertGrassAction(),
                new InsertHerbivoreAction(),
                new MoveAllCreatureAction()
        );
        initialization();
    }

    public int getCounterOfMoves() {
        return counterOfMoves;
    }

    public void initialization() {
        for (Action action : initActions) {
            action.perform(map);
        }
        render.render(map);
    }

    public void nextTurn() {
        for (Action action : turnActions) {
            action.perform(map);
        }
        counterOfMoves++;
        render.render(map);
    }

    public void startSimulation() {
        Runnable runnable = () -> {
            while(true) {
                for (Action action : turnActions) {
                    action.perform(map);
                }
                counterOfMoves++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                render.render(map);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        pauseSimulation(thread);
    }

    private void pauseSimulation(Thread thread) {
        System.out.println("Остановить симуляцию?");
        System.out.println("Введите 1, если да!");
        Scanner input = new Scanner(System.in);
        while (true) {
            int number = input.nextInt();
            if (number == STOP_SIMULATION) {
                thread.interrupt();
                return;
            }
            System.out.println("Неправильное число, введите 1, чтобы остановить симуляцию!");
        }
    }
}
