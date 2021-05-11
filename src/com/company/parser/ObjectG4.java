package com.company.parser;

public class ObjectG4 extends Sentence{

    private Sentence determinerG2;
    private Sentence nounG4;

    public ObjectG4(Sentence determinerG2, Sentence nounG4) {
        this.determinerG2 = determinerG2;
        this.nounG4 = nounG4;
    }

    @Override
    public String show() {
        return (determinerG2 == null ? "" : determinerG2.show() + " ") + nounG4.show();
    }

}
