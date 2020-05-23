package ds.algo.mineditdistance;

import ds.algo.utils.ArrayUtils;

public class MinEditDistance {

    ArrayUtils<Integer> arrayUtils = new ArrayUtils<Integer>();
    /**
     * Minimum operations needed to convert s1 to s2 using add, remove or change operations.
     * @param s1
     * @param s2
     */
    public void minEditDistanceDP(String s1, String s2){
        Integer[][] T = new Integer[s1.length()][s2.length()];

        for(int i=0;i<s1.length();i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0) T[i][j] = j; //case for single element in one string
                if (j == 0) T[i][j] = i; //same as previous
                if (i != 0 && j != 0) {
                    if (s1.charAt(i) == s2.charAt(j))
                        T[i][j] = T[i - 1][j - 1]; //just take corner value
                    else
                        T[i][j] = Math.min(T[i - 1][j - 1],
                                Math.min(T[i - 1][j], T[i][j - 1]))+1; //min of prev,above,diag + 1
                }
            }
        }
        arrayUtils.print2DArray(T);
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "azced";
        new MinEditDistance().minEditDistanceDP(s1,s2);
    }
}
