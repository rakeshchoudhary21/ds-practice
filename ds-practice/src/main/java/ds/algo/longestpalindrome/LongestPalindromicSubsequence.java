package ds.algo.longestpalindrome;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    /**
     * a g b d b a-> Longest palindrom subsequence is a b d b a
     * @param str
     */
    public static void longestPalindromicSubsequence(String str){
        int N = str.length();
        int[][] T = new int[N][N];
        for(int l=0;l<N;l++){
            for(int i=0;i<N-l;i++){
                int j = i+l;
                for(int k=i;k<=j;k++){
                    if(i==k) {
                        T[i][j]=1;
                        continue;
                    }
                    if(str.charAt(i) == str.charAt(j))
                        T[i][j] = T[i+1][j-1]+2;
                    else T[i][j] = Math.max(T[i][j-1],T[i+1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
    }

    public static void main(String[] args) {
        String s = "agbdba";
        longestPalindromicSubsequence(s);
    }
}
