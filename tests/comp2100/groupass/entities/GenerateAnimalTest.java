package comp2100.groupass.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateAnimalTest {

    @Test
    public void generateBISON() {
        Player player = new Player("a",0,"forest");
        int level = player.getLevel();
        Animal animal = new GenerateAnimal().generateAnimal(level);
        assertEquals(animal, Animal.BISON);
    }

    @Test
    public void generateDEER(){
        Player player = new Player("a",1,"forest");
        int level = player.getLevel();
        Animal animal = new GenerateAnimal().generateAnimal(level);
        assertEquals(animal, Animal.DEER);
    }

    @Test
    public void generateTROUT(){
        Player player = new Player("a",2,"home");
        player.setLocationName("forest");
        int level = player.getLevel();
        Animal animal = new GenerateAnimal().generateAnimal(level);
        assertEquals(animal, Animal.TROUT);
    }

    @Test
    public void generateRABBIT(){
        Player player = new Player("a",3,"home");
        player.setLocationName("forest");
        int level = player.getLevel();
        Animal animal = new GenerateAnimal().generateAnimal(level);
        assertEquals(animal, Animal.RABBIT);
    }
}