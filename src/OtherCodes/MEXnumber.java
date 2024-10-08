package OtherCodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MEXnumber {

    private static int mex( int arr[] , int index ) {
        int mex = 0;
        for (int i = index; i < arr.length; i++) {
            if (i != 0 && arr[i - 1] == arr[i]) {
                continue;
            } else if (arr[i] <= mex) {
                mex++;
            }
        }
        // System.out.println(mex);
        return mex;
    }
    private static int newMex( int arr[] ){
        int mex = mex(arr,0);
        int n = 0;
        int newMex = 0;
        for( int j = 0; j < arr.length; j++ ){
            if( arr[j] <= mex ){
                n++;
                newMex = mex(arr,n);
                if( newMex != mex ){
                    return n;
                }
            }

        }
        return -2;
    }

    public static void main(String[] args) {

        int arr[] = {0,1,1,4};
        // int arr[] = {2,4,11};
        System.out.println( newMex( arr ));

        HashSet<Character> has = new HashSet<>();
        has.add('e');
        System.out.println(has);

    }
}
