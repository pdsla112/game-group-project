package com.company.parser.elements;

import com.company.parser.elements.Sentence;

public class Unknown extends Sentence {

    private String word;

    public Unknown(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
