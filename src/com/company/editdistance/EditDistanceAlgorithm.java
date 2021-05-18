package com.company.editdistance;

public class EditDistanceAlgorithm {
    public static int[][] store;

    public static int minDistance(String seq1, String seq2){
        int[][] dp = new int[seq1.length() + 1][seq2.length() + 1];

        for (int i = 0; i <= seq1.length(); i++) {
            for (int j = 0; j <= seq2.length(); j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (seq1.charAt(i - 1) == seq2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = getMin(
                            dp[i - 1][j - 1] + Cost.REPLACE.getCost(),
                            dp[i - 1][j] + Cost.DELETE.getCost(),
                            dp[i][j - 1] + Cost.INSERT.getCost()
                    );
            }
        }
        return dp[seq1.length()][seq2.length()];
    }

    public static int getMin(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        return z;
    }
}
