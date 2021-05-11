package com.company.parser;

public class DeterminerG1 extends Sentence{

    public String word;

    public DeterminerG1(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
