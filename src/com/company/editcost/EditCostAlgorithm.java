package com.company.editcost;

public class EditCostAlgorithm {
    public static int[][] store;

    public static int minDistance(String seq1, String seq2){
        store = new int[seq1.length()][seq2.length()];
        fillWithNegatives(store, seq1.length(), seq2.length());
        return minDistanceRecursive(seq1, seq2, seq1.length()-1, seq2.length()-1);
    }

    public static int minDistanceRecursive(String seq1, String seq2, int pointer1, int pointer2) {
        if (pointer1 == 0 && pointer2 == 0 && seq1.charAt(0) == seq2.charAt(0)) {
            return 0;
        }

        if (pointer1 == 0 && pointer2 == 0 && seq1.charAt(0) != seq2.charAt(0)) {
            return Cost.REPLACE.getCost();
        }

        if (pointer1 == 0 && pointer2 > 0) {
            return pointer2 + Cost.REPLACE.getCost();
        }

        if (pointer2 == 0 && pointer1 > 0) {
            return pointer1 + Cost.REPLACE.getCost();
        }

        if (seq1.charAt(pointer1) == seq2.charAt(pointer2)) {
            if (alreadyExists(store, pointer1 - 1, pointer2 - 1)) {
                return store[pointer1 - 1][pointer2 - 1];
            }
            store[pointer1 - 1][pointer2 - 1] = minDistanceRecursive(seq1, seq2, pointer1 - 1, pointer2 - 1);
            return store[pointer1 - 1][pointer2 - 1];
        } else {
            int result1;
            int result2;
            int result3;
            if (alreadyExists(store, pointer1, pointer2 - 1)) {
                result1 = Cost.INSERT.getCost() + store[pointer1][pointer2 - 1];
            } else {
                store[pointer1][pointer2 - 1] = minDistanceRecursive(seq1, seq2, pointer1, pointer2 - 1);
                result1 = Cost.INSERT.getCost() + store[pointer1][pointer2-1];
            }

            if (alreadyExists(store, pointer1 - 1, pointer2)) {
                result2 = Cost.DELETE.getCost() + store[pointer1 - 1][pointer2];
            } else {
                store[pointer1 - 1][pointer2] = minDistanceRecursive(seq1, seq2, pointer1 - 1, pointer2);
                result2 = Cost.DELETE.getCost() + store[pointer1 - 1][pointer2];
            }

            if (alreadyExists(store, pointer1 - 1, pointer2 - 1)) {
                result3 = Cost.REPLACE.getCost() + store[pointer1 - 1][pointer2 - 1];
            } else {
                store[pointer1 - 1][pointer2 - 1] = minDistanceRecursive(seq1, seq2, pointer1 - 1, pointer2 - 1);
                result3 = Cost.REPLACE.getCost() + store[pointer1 - 1][pointer2 - 1];
            }
            return getMin(result1, result2, result3);
        }
    }

    public static void fillWithNegatives(int[][] store, int xLength, int yLength) {
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                store[i][j] = -1;
            }
        }
    }

    public static boolean alreadyExists(int[][] store, int x, int y) {
        if (store[x][y] == -1)
            return false;
        return true;
    }

    public static int getMin(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;

        if (y <= x && y <= z)
            return y;

        return z;
    }
}
