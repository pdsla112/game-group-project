package com.company.enemies;

public enum Animal {

    DEER(40), RABBIT(70), TROUT(50), BISON(20);

    private int huntingDifficulty; //replace to animalHp?

    Animal(final int huntingDifficulty) {
        this.huntingDifficulty = huntingDifficulty;
    }

    public int getHuntingDifficulty() {
        return this.huntingDifficulty;
    }

    //public boolean isAlive() {
    //    return animalHp >0;
    //}
}
