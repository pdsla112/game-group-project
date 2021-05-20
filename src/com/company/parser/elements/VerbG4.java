package com.company.parser.elements;

public class VerbG4 extends Sentence {

    public String word;

    public VerbG4(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
