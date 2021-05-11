package com.company.parser;

public class VerbG3 extends Sentence{

    public String word;

    public VerbG3(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
