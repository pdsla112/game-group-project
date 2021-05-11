package com.company.parser;

public class ObjectG3 extends Sentence{

    private Sentence determinerG2;
    private Sentence nounG3;

    public ObjectG3(Sentence determinerG2, Sentence nounG3) {
        this.determinerG2 = determinerG2;
        this.nounG3 = nounG3;
    }

    @Override
    public String show() {
        return (determinerG2 == null ? "" : determinerG2.show() + " ") + nounG3.show();
    }

}
