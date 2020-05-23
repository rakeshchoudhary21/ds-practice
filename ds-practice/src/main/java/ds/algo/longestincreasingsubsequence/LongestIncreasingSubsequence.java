package ds.algo.longestincreasingsubsequence;

import ds.algo.utils.ArrayUtils;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    ArrayUtils<Integer> arrayUtils = new ArrayUtils<Integer>();
    /**
     * Given a series of numbers, we need to tell longest increasing subsequence
     */

    public static void longestIncrSubsequence(int[] arr){
        int[] T = new int[arr.length];
        Arrays.fill(T,1); //each item forms subsequence of 1 atleast
        int i = 1;
        int j = 0;
        while (j < arr.length && i < arr.length){
            if(arr[i] > arr[j]) {
                T[i] = Math.max(T[i],T[j] + 1); //means item at j contributes to subsequence
                j++;
            }
            else if(arr[i] <= arr[j])
                j++;
            if(i == j){
                j=0;
                i++;
            }
        }
        System.out.println(Arrays.toString(T));
    }

    public static void main(String[] args) {
        int[] seq1 = {3,4,-1,0,6,2,3};
        int[] seq2 = {2,5,1,8};
        longestIncrSubsequence(seq1);
        longestIncrSubsequence(seq2);
    }
}
