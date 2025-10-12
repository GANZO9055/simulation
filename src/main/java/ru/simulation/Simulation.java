package ru.simulation;

import ru.simulation.rendering.MapConsoleRender;
import ru.simulation.rendering.Render;

public class Simulation {
    public static void main(String[] args) {
        Render consoleRender = new MapConsoleRender();

        consoleRender.render();
    }
}