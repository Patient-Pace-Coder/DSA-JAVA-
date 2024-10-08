package STRIVER_DSA_SHEET.Arrays.ArraysEasy;

import java.util.Arrays;

public class ZeroMatrix01 {

    public int[][] SetMatrixZeroes(int arr[][]){

        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[i][j]==0){
                    for(int k=0;k<arr.length;k++) {  // filling the row with zeroes
                        arr[i][k] = 0;
                    }

                    if(i==0){
                        arr[1][j]=0;

                    }
                    else{
                        arr[0][j]=0;

                    }
                }
            }

        }
        return arr;

    }

    public static void main(String[] args) {
        ZeroMatrix01 obj=new ZeroMatrix01();
        int arr[][]={ {2,4,3},{1,0,0}};
        System.out.println(Arrays.deepToString(obj.SetMatrixZeroes(arr)));
    }
}
