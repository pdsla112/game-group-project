package comp2100.groupass.menus;

public class Attack implements MenuItem{
    String attackName;
    int attackDamage;
    int selfDamage;

    public Attack(String attackName, int attackDamage, int selfDamage) {
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.selfDamage = selfDamage;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getSelfDamage() {
        return selfDamage;
    }

    @Override
    public String getOptionText() {
        return attackName + " (" + attackDamage + "dmg/-"+selfDamage + "hp)";
    }
}
