package ds.algo.cuttingrod;

import java.util.Arrays;

public class CuttingRodDP {

    /**
     * We have a given lengths of rods and profit to be had by selling rod at that length.
     * Now we are given a rod that needs to be cut to maximize the profit by looking at the data.(rod lengths and profits)
     * @param profits
     * @param lengths
     * @param rodLength
     */

    public static void cutRod(int[] profits, int[] lengths, int rodLength){
        int[][] T = new int[lengths.length][rodLength+1];

        for(int i=0;i<lengths.length;i++){
            for(int j=0;j<rodLength+1;j++){
                if(i==0)
                    T[0][j] = (j >= lengths[0])? (profits[0]+ T[i][j-lengths[0]]): 0; //special case
                else{
                    if(j<lengths[i]) T[i][j] = T[i-1][j];
                    else {
                        T[i][j] = Math.max(T[i-1][j],(profits[i]+ T[i][j-lengths[i]]));
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(T));


    }


    public static void main(String[] args) {
        int[] lengths = {1,2,3,4};
        int[] profits = {2,5,7,8};
        int rodLength = 5;
        cutRod(profits,lengths,rodLength);
    }
}
