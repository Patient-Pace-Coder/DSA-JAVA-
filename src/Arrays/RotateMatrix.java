package Arrays;
import java.util.Arrays;

public class RotateMatrix {

    // leetcode question : 48
    public int[][] rotate90Degrees(int arr[][]){

        // Transpose of a matrix

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<=arr.length-1;j++){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        for( int i = 0; i < arr.length; i++ ){
            int startIdx = 0;
            int endIdx = arr.length - 1;
            while ( startIdx < endIdx ){
                int temp = arr[i][startIdx];
                arr[i][startIdx] = arr[i][endIdx];
                arr[i][endIdx] = temp;
                startIdx++;
                endIdx--;
            }
        }
       // System.out.println();
         //  reversing each row
       //  for(int i=0;i<arr.length;i++){
       //      int p1=0; int p2=arr.length-1;   // two pointer approach for reversing each row
       //      while(p1<p2){
       //
       //          int temp=arr[i][p1];
       //          arr[i][p1]=arr[i][p2];
       //          arr[i][p2]=temp;
       //          p1++;
       //          p2--;
       //      }
       //  }
       //
       // for(int i=0;i<arr.length;i++){
       //     for(int j=0;j<arr.length;j++){
       //         System.out.print(arr[i][j]+" ");
       //     }
       //     System.out.println();
       // }
        return arr;
    }
    public static void main(String[] args) {
        RotateMatrix obj=new RotateMatrix();
        int arr[][]={
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(Arrays.deepToString(obj.rotate90Degrees(arr)));
    }
}
