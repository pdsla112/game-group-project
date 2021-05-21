package comp2100.groupass.data;

public class LocationData {
    private String location;
    private String initialText;
    private PsychoData psychoData;
    private GoodCharacterData goodCharacterData;
    private ItemData itemData;
    private ZombieData zombieData;

    public LocationData(String location, String initialText, PsychoData psychoData, GoodCharacterData goodCharacterData, ItemData itemData, ZombieData zombieData) {
        this.location = location;
        this.initialText = initialText;
        this.psychoData = psychoData;
        this.goodCharacterData = goodCharacterData;
        this.itemData = itemData;
        this.zombieData = zombieData;
    }

    public String getLocation() {
        return this.location;
    }

    public String getInitialText() {
        return this.initialText;
    }

    public PsychoData getPsychoData() {
        return this.psychoData;
    }

    public GoodCharacterData getGoodCharacterData() {
        return this.goodCharacterData;
    }

    public ItemData getItemData() {
        return this.itemData;
    }

    public ZombieData getZombieData() {
        return this.zombieData;
    }

    public static void main(String[] args) {
        LocationData hospital = LocationJSON.getSpecificLocationData("hospital");
        System.out.println(hospital.getInitialText());
        System.out.println(hospital.getLocation());
    }
}
