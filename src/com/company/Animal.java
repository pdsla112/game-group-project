package com.company;

public enum Animal {
    DEER(40), RABBIT(70), TROUT(50), BISON(20);

    Animal(final int huntingDifficulty) {
        this.huntingDifficulty = huntingDifficulty;
    }

    private int huntingDifficulty;

    public int getHuntingDifficulty() {
        return this.huntingDifficulty;
    }
}
