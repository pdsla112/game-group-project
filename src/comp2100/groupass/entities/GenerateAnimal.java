package comp2100.groupass.entities;

public class GenerateAnimal {
    public Animal generateAnimal(int level) {
        switch (level) {
            case 0:
                return Animal.BISON;
            case 1:
                return Animal.DEER;
            case 2:
                return Animal.TROUT;
            case 3:
                return Animal.RABBIT;
        }
        return Animal.BISON;
    }
}
