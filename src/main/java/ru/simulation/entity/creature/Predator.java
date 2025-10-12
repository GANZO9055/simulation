package ru.simulation.entity.creature;

public class Predator extends Creature {
    private static final int DEFAULT_HP = 100;
    private static final int DEFAULT_SPEED = 3;

    public Predator(Coordinate coordinate) {
        super(DEFAULT_HP, DEFAULT_SPEED, coordinate);
    }

    @Override
    public void makeMove() {
        super.makeMove();
    }

    @Override
    public String imageOutputToConsole() {
        return "🐺";
    }
}
