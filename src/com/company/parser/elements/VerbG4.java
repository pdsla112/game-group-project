package com.company.parser.elements;

import com.company.parser.elements.Sentence;

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
