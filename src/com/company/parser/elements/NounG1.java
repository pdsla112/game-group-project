package com.company.parser.elements;

public class NounG1 extends Sentence {

    public String word;

    public NounG1(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
