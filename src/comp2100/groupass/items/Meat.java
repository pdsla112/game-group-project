package comp2100.groupass.items;

import comp2100.groupass.entities.Player;

public class Meat extends Item {
    private int hpAdd;   // Amount that the meat heals the player

    public Meat(int hpAdd) {
        this.hpAdd = hpAdd;
    }

    public int gethpAddValue() {
        return this.hpAdd;
    }

    /**
     * add to player's health (max 100)
     */
    @Override
    public void use(Player player) {
        int oldHp = player.getHealth();
        player.setHealth(Math.min(100,player.getHealth()+hpAdd));
        int changeHp = player.getHealth() - oldHp;
        System.out.println("You have consumed the meat. +" + changeHp + " Hp");
    }
}
