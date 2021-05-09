package com.company.data;

public class PsychoData {
    private String introText;
    private String approachText;
    private String avoidText;

    public PsychoData(String introText, String approachText, String avoidText) {
        this.introText = introText;
        this.approachText = approachText;
        this.avoidText = avoidText;
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
