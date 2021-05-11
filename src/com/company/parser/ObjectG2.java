package com.company.parser;

public class ObjectG2 extends Sentence{

    private Sentence determinerG2;
    private Sentence nounG2;

    public ObjectG2(Sentence determinerG2, Sentence nounG2) {
        this.determinerG2 = determinerG2;
        this.nounG2 = nounG2;
    }

    @Override
    public String show() {
        return (determinerG2 == null ? "" : determinerG2.show() + " ") + nounG2.show();
    }

}
