package com.company.enemies;
import com.company.characters.Player;

public class GenerateAnimal {

    public Animal animalEachLoc(Player player) {
        // locations without animals, every except forest
        if ("forest".equals(player.getLocationName())) {
            return generateAnimal(player.getLevel());
        }
        return null;
    }

    private Animal generateAnimal(int level) {
        if (level == 0)
            return Animal.BISON;
        else if (level == 1)
            return Animal.DEER;
        else if (level == 2)
            return Animal.TROUT;
        else
            return Animal.RABBIT;
    }
}
