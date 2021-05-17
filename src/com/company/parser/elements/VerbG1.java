package com.company.parser.elements;

import com.company.parser.elements.Sentence;

public class VerbG1 extends Sentence {

    public String word;

    public VerbG1(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
