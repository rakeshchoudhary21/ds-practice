package ds.algo.coinchange;

import ds.algo.utils.ArrayUtils;

import java.util.Arrays;

public class CoinChangeProblem {
    /**
     * We have infinite supply of coins, this problem is unique in that sense
     */

    private ArrayUtils<Integer> arrayUtils = new ArrayUtils<Integer>();

    public void coinChangeNonFixedNumberOfCoins1(int[] coins, int target) {
        Integer[][] T = new Integer[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j == coins[i]) T[i][j] = 1; //same change so just one coin needed
                else {
                    if (i == 0) T[i][j] = T[i][j - coins[i]] + 1;
                    else{
                        if(j < coins[i]) //coin cant contribute since its more than the j value
                            T[i][j] = T[i-1][j];
                        else T[i][j] = Math.min(T[i-1][j],T[i][j-coins[i]]+1);
                    }
                }
            }
        }
        arrayUtils.print2DArray(T);
    }

    /**
     * Below is a variation, in this case also the coins are in infinite supply.
     * We still need to find minimum number of coins needed to tender the change
     * @param coins
     * @param target
     */
    public void coinChangeNonFixedNumberOfCoins2(int[] coins, int target){
        Integer[] T = new Integer[target+1];
        Arrays.fill(T,Integer.MAX_VALUE);
        T[0]=0;
        for(Integer coin: coins){
            for(int j=0;j<=target;j++)
                if(j >=coin)
                    T[j] = Math.min(T[j], 1+T[j-coin]);
        }

        System.out.println(Arrays.toString(T));
    }

    public static void main(String[] args) {
        int target = 15;
        int[] coins = {1,5,6,8};
        new CoinChangeProblem().coinChangeNonFixedNumberOfCoins1(coins,target);
        System.out.println("=======================variation-2===================");
        new CoinChangeProblem().coinChangeNonFixedNumberOfCoins2(coins,target);
    }
}
