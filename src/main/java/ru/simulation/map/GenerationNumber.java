package ru.simulation.map;

import java.util.Random;

public class GenerationNumber {
    public int getNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}
