package com.company.parser.elements;

public class VerbG2 extends Sentence {

    public String word;

    public VerbG2(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
