package ds.algo.coinchange;


import java.util.Arrays;
import java.util.Collections;

public class CoinChangeLimitedCoins {

    public static void main(String[] args) {
        Integer[] coins = {1, 2, 3, 4}; //needs descending order
        Arrays.sort(coins, Collections.reverseOrder());
        int[] counts = {1, 1, 1,1};
        int target = 7;
        Integer[] nums = combine(coins, counts);
        System.out.println(minCount(nums, target, 0, 0, 0));
    }

    private static int minCount(Integer[] nums, int target, int sum, int current, int count) {
        if (current > nums.length) return -1;
        if (sum == target) return count;
        if (sum + nums[current] <= target) {
            return minCount(nums, target, sum + nums[current], current + 1, count + 1);
        } else {
            return minCount(nums, target, sum, current + 1, count);
        }
    }

    /**
     * This method just sorts in descending order and puts all entries numerically into one array
     * like 2 coins of 5, 3 coins of 2 -> [5,5,2,2,2]
     * @param coins
     * @param counts
     * @return
     */
    private static Integer[] combine(Integer[] coins, int[] counts) {
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        Integer[] returnArray = new Integer[sum];
        int returnArrayIndex = 0;
        for (int i = 0; i < coins.length; i++) {
            int count = counts[i];
            while (count != 0) {
                returnArray[returnArrayIndex] = coins[i];
                returnArrayIndex++;
                count--;
            }
        }
        return returnArray;
    }
}
