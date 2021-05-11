package com.company.parser;

public class Unknown extends Sentence{

    private String unknown;

    public Unknown(String unknown) {
        this.unknown = unknown;
    }

    @Override
    public String show() {
        return unknown;
    }

}
