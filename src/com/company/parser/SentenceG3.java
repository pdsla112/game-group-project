package com.company.parser;

public class SentenceG3 extends Sentence{

    private Sentence verbG3;
    private Sentence objectG3;

    public SentenceG3(Sentence verbG3, Sentence objectG3) {
        this.verbG3 = verbG3;
        this.objectG3 = objectG3;
    }

    @Override
    public String show() {
        return verbG3.show() + " " + objectG3.show();
    }

}
