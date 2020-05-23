package ds.algo.knapsack;


import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackDPTest {

    @Test
    public void knapsack() {

        int[] weights = {1,3,4,5};
        int[] vals = {1,4,5,7};
        assertEquals(KnapsackDP.knapsack(weights,vals,7),9);

        int[] wt = {10, 20, 30, 40};
        int[] val = {60, 100, 120, 40};
        int capacity = 50;
        assertEquals(KnapsackDP.knapsack(wt,val,capacity),220);

    }
}