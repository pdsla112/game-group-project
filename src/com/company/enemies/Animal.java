package com.company.enemies;

public enum Animal {

    DEER(40), RABBIT(70), TROUT(50), BISON(20);

    private int huntingDifficulty; //for animalHp

    Animal(int huntingDifficulty) {
        this.huntingDifficulty = huntingDifficulty;
    }

    public int getHuntingDifficulty() {
        return this.huntingDifficulty;
    }

    public void setHuntingDifficulty(int huntingDifficulty){this.huntingDifficulty=huntingDifficulty;}

    public boolean isAlive() {
        return huntingDifficulty > 0;
    }

    //assume animal doesn't attack player
}
