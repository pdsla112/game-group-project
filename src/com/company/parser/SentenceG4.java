package com.company.parser;

public class SentenceG4 extends Sentence{

    public Sentence verbG4;
    public Sentence objectG4;
    public Sentence prepositionG1;

    public SentenceG4(Sentence verbG4, Sentence prepositionG1, Sentence objectG4) {
        this.verbG4 = verbG4;
        this.objectG4 = objectG4;
        this.prepositionG1 = prepositionG1;
    }

    @Override
    public String show() {
        return  verbG4.show() + " " + (prepositionG1 == null ? "" : prepositionG1.show() + " ") + objectG4.show();
    }

}
