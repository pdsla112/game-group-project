package com.company.parser;

public class HelpExp extends Exp{

    public HelpExp() {}

    @Override
    public String show() {
        return "help";
    }

    @Override
    public int evaluate() {
        return 0;
    }
}
