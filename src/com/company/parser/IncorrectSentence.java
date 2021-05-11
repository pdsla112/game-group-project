package com.company.parser;

public class IncorrectSentence extends Sentence{

    public Sentence s1;
    public Sentence s2;

    public IncorrectSentence(Sentence s1, Sentence s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    public IncorrectSentence(Sentence s1) {
        this.s1 = s1;
    }

    @Override
    public String show() {
        String rtn = "";
        if (s1 != null && s1 instanceof Unknown) {
            rtn += "Unknown: " + s1.show();
        } else if (s2 != null && s2 instanceof Unknown) {
            rtn += "Unknown: " + s2.show();
        } else {
            rtn += "Incorrect sentence structure.";
        }
        return rtn;

    }

}
