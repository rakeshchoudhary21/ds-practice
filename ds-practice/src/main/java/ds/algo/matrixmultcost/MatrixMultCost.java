package ds.algo.matrixmultcost;

import java.util.Arrays;
import java.util.List;

class MatrixProp{
    int first;
    int sec;
    MatrixProp(int first,int sec){
        this.first = first;
        this.sec = sec;
    }

    @Override
    public String toString() {
        return "[" +
                "first=" + first +
                ", sec=" + sec +
                ']';
    }
}

public class MatrixMultCost {

    public static void findCost(List<MatrixProp> matrixPropList){
        int N = matrixPropList.size();
        int T[][] = new int[N][N];
        int MIN = 0;
        for(int l=0; l < N; l++){
            for(int i=0; i < N - l; i++){
                int j = i + l;
                MIN = Integer.MAX_VALUE;
                //we are keeping k<j because here target is upper triangle only. and actual diagonal is zero anyway
                for(int k=i; k < j; k++){
                    //remember we are taking k+1 here so last element will be covered. no need to go till k <= j
                    T[i][j] = Math.min(MIN,T[i][k] + T[k+1][j] +
                            (matrixPropList.get(i).first*matrixPropList.get(k).sec*matrixPropList.get(j).sec));
                    MIN = T[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
    }


    public static void main(String[] args) {
        /**MatrixProp one = new MatrixProp(2,3);
        MatrixProp two = new MatrixProp(3,6);
        MatrixProp three = new MatrixProp(6,4);
        MatrixProp four = new MatrixProp(4,5);*/
        MatrixProp one = new MatrixProp(1,2);
        MatrixProp two = new MatrixProp(2,3);
        MatrixProp three = new MatrixProp(3,4);
        MatrixProp four = new MatrixProp(4,3);

        //minCost(Arrays.asList(one,two,three,four));
        //processUpperDiagonal();
        findCost(Arrays.asList(one,two,three,four));


    }
}
