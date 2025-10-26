package ru.simulation.rendering;

import ru.simulation.entity.Entity;
import ru.simulation.entity.Grass;
import ru.simulation.entity.Rock;
import ru.simulation.entity.Tree;
import ru.simulation.entity.creature.Herbivore;
import ru.simulation.entity.creature.Predator;

public class PictureFactory {
    public String getPicture(Entity entity) {
        String picture;
        if (entity instanceof Grass) {
            picture = "🌾";
        } else if (entity instanceof Rock) {
            picture = "🗻";
        } else if (entity instanceof Tree) {
            picture = "🌳";
        } else if (entity instanceof Herbivore) {
            picture = "🐇";
        } else if (entity instanceof Predator) {
            picture = "🐺";
        } else {
            picture = "🟩";
        }
        return picture;
    }
}
