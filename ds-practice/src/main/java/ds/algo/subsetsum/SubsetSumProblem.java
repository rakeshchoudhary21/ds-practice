package ds.algo.subsetsum;

import ds.algo.utils.ArrayUtils;


public class SubsetSumProblem {

    private final ArrayUtils<Boolean> arrayUtils = new ArrayUtils<Boolean>();
    /**
     * Using the set approach may not work since target number could be composed of multiple numbers.
     * @param arr
     * @param target
     * @return
     */

    public void subsetSum(int[] arr, int target){
        Boolean[][] T = new Boolean[arr.length][target+1];
        //zero can always be formed with or without any number being available.
        T[0][0] = true;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                if((i==0 && j==0) || (j==0)){
                    T[i][j] = true;
                    continue;
                }
                if(arr[i] > j && i!=0) T[i][j] = T[i-1][j];
                else if(arr[i] == j) T[i][j] = true;
                else{
                    if(j-arr[i]-1>=0 && i!=0)
                    T[i][j] = T[i-1][j-arr[i]-1];
                }
            }
        }
        arrayUtils.print2DArray(T);
    }

    public static void main(String[] args) {
        int target = 11;
        int[] arr = {2,3,7,8,10};
        new SubsetSumProblem().subsetSum(arr,target);
    }
}
