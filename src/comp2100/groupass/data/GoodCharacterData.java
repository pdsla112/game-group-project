package comp2100.groupass.data;

public class GoodCharacterData {
    private String characterType;
    private String introText;
    private String approachText;
    private String avoidText;

    public GoodCharacterData(String characterType, String introText, String approachText, String avoidText) {
        this.characterType = characterType;
        this.introText = introText;
        this.approachText = approachText;
        this.avoidText = avoidText;
    }

    public String getCharacterType() {
        return this.characterType;
    }

    public String getIntroText() {
        return this.introText;
    }

    public String getApproachText() {
        return this.approachText;
    }

    public String getAvoidText() {
        return this.avoidText;
    }
}
