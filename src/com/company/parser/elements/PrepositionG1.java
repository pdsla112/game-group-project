package com.company.parser.elements;

public class PrepositionG1 extends Sentence {

    public String word;

    public PrepositionG1(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
