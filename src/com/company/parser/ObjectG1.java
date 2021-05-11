package com.company.parser;

public class ObjectG1 extends Sentence{

    private Sentence determinerG1;
    private Sentence nounG1;

    public ObjectG1(Sentence determinerG1, Sentence nounG1) {
        this.determinerG1 = determinerG1;
        this.nounG1 = nounG1;
    }

    @Override
    public String show() {
        return (determinerG1 == null ? "" : determinerG1.show() + " ") + nounG1.show();
    }

}
