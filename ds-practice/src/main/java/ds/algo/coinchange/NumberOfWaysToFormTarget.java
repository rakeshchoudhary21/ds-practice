package ds.algo.coinchange;

import java.util.Arrays;

public class NumberOfWaysToFormTarget {


    public static void numberOfWays(int[] coins, int target){
        int[][] T = new int[coins.length][target+1];

        T[0][0]=1;
        for(int i=0;i<coins.length;i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0)
                    T[i][j] = (j >= coins[i]) ? 1 : T[i][j];
                else {
                    T[i][j] = (j-coins[i]>=0)?T[i][j - coins[i]] + T[i - 1][j] : T[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 6;
        numberOfWays(coins,target);
    }
}
