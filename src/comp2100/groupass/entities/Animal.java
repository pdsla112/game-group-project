package comp2100.groupass.entities;

public enum Animal {

    DEER(40), RABBIT(70), TROUT(50), BISON(20);

    private int huntingDifficulty;

    Animal(int huntingDifficulty) {
        this.huntingDifficulty = huntingDifficulty;
    }

    public int getHuntingDifficulty() {
        return this.huntingDifficulty;
    }

    public void setHuntingDifficulty(int huntingDifficulty){ this.huntingDifficulty = huntingDifficulty; }

    public boolean isAlive() {
        return huntingDifficulty > 0;
    }
}
