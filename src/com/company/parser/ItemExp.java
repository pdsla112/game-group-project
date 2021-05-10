package com.company.parser;

public class ItemExp extends Exp{
    private Integer id;

    public ItemExp(Integer value) {
        this.id = id;
    }

    @Override
    public String show() {
        return id.toString();
    }

    @Override
    public int evaluate() {
        return id;
    }
}
