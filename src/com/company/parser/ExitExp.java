package com.company.parser;

public class ExitExp extends Exp{

    public ExitExp() {}

    @Override
    public String show() {
        return "exit";
    }

    @Override
    public int evaluate() {
        return 0;
    }
}
