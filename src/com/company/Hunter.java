package com.company;

public class Hunter extends Character {
    private Animal game;  // "game" as in wild animal game.
    private boolean isApproached;

    public Hunter(int attackLevel, Animal game, boolean isApproached) {
        super(attackLevel);
        this.game = game;
        this.isApproached = isApproached;
    }

    public void getApproached() {
        this.isApproached = true;
    }

    public boolean getApproachedValue() {
        return this.isApproached;
    }

    public int getGameNutrition() {
        switch (game) {
            case TROUT:
                return 20;
            case RABBIT:
                return 30;
            case DEER:
                return 60;
            case BISON:
                return 80;
        }
        return 0;
    }

}
