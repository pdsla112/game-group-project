package com.company.parser;


public class UnknownExp extends Exp{

    public UnknownExp() {}

    @Override
    public String show() {
        return "unknown";
    }

    @Override
    public int evaluate() {
        return 0;
    }
}
