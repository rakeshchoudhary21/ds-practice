package ds.algo.matrixmultcost;

public class MultipleInterationOnArray {


    static void multiInteration(int[] arr,int N){
        for(int l=0;l<N;l++) {
            for (int i = 0; i < N - l; i++) {
                int j = i + l;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + "\t");
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        multiInteration(new int[]{1,2,3,4},4);
    }
}
