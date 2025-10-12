package ru.simulation.entity.creature;

public class Herbivore extends Creature {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SPEED = 2;

    public Herbivore(Coordinate coordinate) {
        super(DEFAULT_HP, DEFAULT_SPEED, coordinate);
    }


    @Override
    public void makeMove() {
        super.makeMove();
    }

    @Override
    public String imageOutputToConsole() {
        return "🐇";
    }
}
