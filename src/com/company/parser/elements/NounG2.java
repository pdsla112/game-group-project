package com.company.parser.elements;

public class NounG2 extends Sentence {

    public String word;

    public NounG2(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
