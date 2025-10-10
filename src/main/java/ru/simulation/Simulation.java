package ru.simulation;

import ru.simulation.entity.Entity;
import ru.simulation.entity.Rock;
import ru.simulation.entity.Tree;
import ru.simulation.entity.creature.Herbivore;

public class Simulation {
    public static void main(String[] args) {
        Entity entity = new Tree();
        System.out.println(entity.imageOutputToConsole());
        //System.out.println("Hello, World!");
    }
}