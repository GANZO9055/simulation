package ru.simulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.initialization();
        while (true) {
            System.out.println("Произвести один ход? Введите 1");
            System.out.println("Произвести долгую симуляцию? Введите 2");
            System.out.println("Выйти из симуляции. Введите 3");
            Scanner input = new Scanner(System.in);
            int result = input.nextInt();
            if (result == 1) {
                simulation.nextTurn();
            } else if (result == 2) {
                System.out.println("Введите количество ходов симуляции: от 1 до 100");
                simulation.startSimulation(input.nextInt());
            } else if (result == 3) {
                System.out.println("Симуляция завершена!");
                return;
            }
            System.out.println("Количество ходов: " + simulation.getCounterOfMoves());
        }
    }
}