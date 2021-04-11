package com.company;

public class Hunter extends Character {
    private Animal game;  // "game" as in wild animal game.

    public Hunter(int attackLevel, Animal game) {
        super(attackLevel);
        this.game = game;
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
