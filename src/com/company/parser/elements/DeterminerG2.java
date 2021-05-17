package com.company.parser.elements;

public class DeterminerG2 extends Sentence {

    public String word;

    public DeterminerG2(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
