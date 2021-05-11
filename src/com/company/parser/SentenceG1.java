package com.company.parser;

public class SentenceG1 extends Sentence{

    public Sentence verbG1;
    public Sentence objectG1;

    public SentenceG1(Sentence verbG1, Sentence objectG1) {
        this.verbG1 = verbG1;
        this.objectG1 = objectG1;
    }

    @Override
    public String show() {
        return verbG1.show() + " " + objectG1.show();
    }

}
