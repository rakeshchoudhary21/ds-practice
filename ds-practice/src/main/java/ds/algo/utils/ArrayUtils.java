package ds.algo.utils;

import java.util.Arrays;

public class ArrayUtils<T> {

    public void print2DArray(T[][] arr) {
        for (T[] temp : arr) {
            if (temp instanceof Boolean[])
                print2DArrayBoolean(temp);
            else if (temp instanceof Integer[])
                print2DArrayInteger(temp);
            else System.out.println(Arrays.deepToString(temp));
        }
    }

    private void print2DArrayInteger(T[] arr) {
        for (T t : arr) {
            if (t == null)
                System.out.printf("" + 0);
            else System.out.printf("" + t);
            System.out.printf(",");
        }
        System.out.println();
    }

    public void print2DArrayBoolean(T[] arr) {
        for (T t : arr) {
            if (t == null)
                System.out.printf("" + false);
            else System.out.printf("" + t);
            System.out.printf(",");
        }
        System.out.println();
    }
}


