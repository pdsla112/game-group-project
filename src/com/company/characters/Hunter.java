package com.company.characters;

import com.company.enemies.Animal;

public class Hunter extends NPC {
    private Animal game;  // "game" as in wild animal game.
    private boolean isApproached;

    public Hunter(String id, Animal game, boolean isApproached) {
        super(id);
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
