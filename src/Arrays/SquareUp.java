package Arrays;

//Given n>=0, create an array length n*n with the following pattern,
// shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1}
// (spaces added to show the 3 groups).
//
//
//        squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
//        squareUp(2) → [0, 1, 2, 1]
//        squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]


import java.util.Arrays;

public class SquareUp {

    public int[] squareUp(int n){
        int nums[]=new int[n*n];
//        for(int i=0;i<n;i++) { // defines number of set's
//            for(int j=0;j<n;j=j+n) { // defines starting index of every set
//                for (int i = k; i < j * n; i++) { // traverses every set
//
//
//                }
//            }
//
//
//        }

//        for(int i=n;i>=1;i--){
//            int k=i*n-1;
//            for(int j=1;j<=i;j++){
//                nums[k--]=j;
//            }
//        }


        for(int i=1;i<=n;i++){ // defines the number of set's

            for(int j=0;j<n-i;j++){  // Add zeroes to the left
                nums[i*n-1-j]=0;
            }

            for(int k=i;k>=1;k--){ // Add numbers in descending order
                nums[i*n-k]=k;
            }
        }


        return nums;

    }

    public static void main(String[] args) {

        SquareUp obj=new SquareUp();
        System.out.println(Arrays.toString(obj.squareUp(3)));

    }
}
