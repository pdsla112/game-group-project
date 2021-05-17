package com.company.parser.elements;

import com.company.parser.elements.Sentence;

public class VerbG3 extends Sentence {

    public String word;

    public VerbG3(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
