package ds.algo.longestcommonsubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {

    /**
     * This would just get the length of subsequence,
     * To get the subsequence itself we will need to start at bottom right corner, and go discovering.
     * Simple rule if the value came from corner then it contributes to the subsequence
     * @param s1
     * @param s2
     */
    public static void longestCommonSubsequnce(String s1, String s2) {
        int[][] T = new int[s1.length()][s2.length()];
        //for a string of length 1 the longest subsequence can be only of length 1
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    //check if first item
                    if (i == 0 || j == 0) T[i][j] = 1;
                    else T[i][j] = T[i - 1][j - 1] + 1;
                } else {
                    if (i == 0 || j == 0){
                        if(i==0 && j!=0) T[i][j] = T[i][j-1];
                        else if(i!=0 && j==0) T[i][j] = T[i-1][j];
                        else T[i][j] = 0;
                    }
                    else T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(T));
    }

    public static void main(String[] args) {
        String s1 = "dgazzzzb";
        String s2 = "dzb";
        longestCommonSubsequnce(s1,s2);
    }

}
