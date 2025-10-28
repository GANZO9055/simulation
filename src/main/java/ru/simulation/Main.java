package ru.simulation;

import ru.simulation.game_map.WorldMap;
import ru.simulation.rendering.MapConsoleRender;
import ru.simulation.rendering.Renderer;

import java.util.Scanner;

public class Main {
    private static final int ONE_MOVE = 1;
    private static final int START_SIMULATION = 2;
    private static final int EXIT_SIMULATION = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер карты");
        System.out.print("По X: ");
        int sizeByX = input.nextInt();
        System.out.print("По Y: ");
        int sizeByY = input.nextInt();

        WorldMap worldMap = new WorldMap(sizeByX, sizeByY);
        Renderer render = new MapConsoleRender();
        Simulation simulation = new Simulation(worldMap, render);

        while (true) {
            System.out.println("Произвести один ход? Введите 1");
            System.out.println("Произвести долгую симуляцию? Введите 2");
            System.out.println("Выйти из симуляции. Введите 3");
            int result = input.nextInt();
            if (result == ONE_MOVE) {
                simulation.nextTurn();
            } else if (result == START_SIMULATION) {
                simulation.startSimulation();
            } else if (result == EXIT_SIMULATION) {
                System.out.println("Симуляция завершена!");
                return;
            }
            System.out.println("Количество ходов: " + simulation.getCounterOfMoves());
        }
    }
}