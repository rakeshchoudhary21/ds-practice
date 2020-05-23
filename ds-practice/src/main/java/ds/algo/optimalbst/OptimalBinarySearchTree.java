package ds.algo.optimalbst;

import ds.algo.utils.ArrayUtils;

import java.util.Arrays;

public class OptimalBinarySearchTree {

    ArrayUtils<Integer> arrayUtils = new ArrayUtils<Integer>();

    /**
     * Given a bunch of keys and the frequency at which they are searched.
     * Construct an optimal bst for this situation
     */

    public void optimalBst(int[] keys, int[] frequency) {
        //note: since both array will have to be equi-length
        int N = keys.length;
        int[][] T = new int[N][N];
        for (int l = 0; l < N; l++) {
            for (int i = 0; i < N - l; i++) {
                int j = i + l;
                int tempCost = getSum(frequency,i,j);
                T[i][j]=Integer.MAX_VALUE;
                int M;
                for (int k = i; k <= j; k++) {
                        M=tempCost+(k-1 < i?0:T[i][k-1])+(k+1>j?0:T[k+1][j]);
                        if(M<T[i][j])
                            T[i][j]=M;
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
    }

    private int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] keys = {10, 12, 16, 21};
        int[] frequency = {4, 2, 6, 3};
        new OptimalBinarySearchTree().optimalBst(keys, frequency);
    }
}
