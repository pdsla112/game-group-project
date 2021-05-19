package com.company.editdistance;

public enum Cost {
    INSERT (1),
    DELETE (1),
    REPLACE (2);

    private final int cost;

    Cost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }
}
