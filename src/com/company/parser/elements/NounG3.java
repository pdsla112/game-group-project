package com.company.parser.elements;

public class NounG3 extends Sentence {

    public String word;

    public NounG3(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
