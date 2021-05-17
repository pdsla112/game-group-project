package com.company.parser.elements;

public class SentenceG2 extends Sentence{

    public Sentence verbG2;
    public Sentence objectG2;

    public SentenceG2(Sentence verbG2, Sentence objectG2) {
        this.verbG2 = verbG2;
        this.objectG2 = objectG2;
    }

    @Override
    public String show() {
        return verbG2.show() + " " + objectG2.show();
    }

}
