package ds.algo.knapsack;

import java.util.Arrays;

/**
 * There is a serious issue with this approach, it needs weights to be sorted in asc order.
 */
public class KnapsackDP {

    /**
     * Its 0/1 so there is just one quantity of each item and also you cant split them
     * for zeroth row just use the value of zeroth item.
     * if j < wt[i] -> T[i][j] = from above
     * else max of val[i] + T[i-1][j-wt[i]], T[i-1][j]
     * @param weights
     * @param vals
     * @param target
     */
    public static int knapsack(int[] weights, int[] vals, int target){

        int[][] T = new int[weights.length][target+1];
        for(int i=0;i<weights.length;i++){
            for(int j=1;j<target+1;j++){
                if(i == 0) T[i][j] = vals[0];
                else {
                    if (j < weights[i]) {
                        T[i][j] = T[i - 1][j];
                    } else {
                        T[i][j] = Math.max(vals[i] + T[i - 1][j - weights[i]], T[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
        return T[weights.length-1][target];
    }
}
