package HashMaps.Questions;

import java.util.HashMap;

public class MaximumDifferenceIndices {

    /*

    Problem Description:

        Given an array Al]of size N. Let us call the difference between indices of an
        element's first and last appearance in the array A[] a gap. Find the maximum possible gap.
        Note that if any element appears only once, then the gap for that element is O

        Constraints:

        1<=N<=10^5

        -105 A1075

        Sample Input and output:

        Example 1

        Input:

        9

        213421517

        Output:

        6

        Explanation:

        For the above test case (Assuming 0-based indexing):

        Number Ts first appearance is at index 1 and last appearance is at index 7.
        This implies gap is 7-1-6 This is the maximum possible in the given test case

     */

    private static int maximumDifferenceIndices( int[] A ){ // [1
        HashMap<Integer,int[]> occurrences = new HashMap<>();

        for( int i = 0; i < A.length; i++ ){
            int element = A[i];
            if( !occurrences.containsKey(element) ){
                occurrences.put(element,new int[]{i,i});
            }
            else if(occurrences.containsKey(element) ){
                occurrences.get(element)[1] = i;
            }
        }

        int maxGap = 0;

        for( int[] indices : occurrences.values() ){
            int gap = indices[1] - indices[0];

            if( gap > maxGap ){
                maxGap = gap;
            }
        }

        return maxGap;
    }

    private static int maxGapIndices( int A[] ){

        int maxGap = 0;
        for( int i = 0; i < A.length; i++ ){
            int gap = 0;
            for( int j = A.length - 1; j >= 0; j-- ){
                if( A[i] == A[j] ){
                    gap = j - i;
                    break;
                }
            }
            if( gap > maxGap ){
                maxGap = gap;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {

        int A[] = {1,6,2,3,4,5,1,5,6};
        // System.out.println(maximumDifferenceIndices(A));
        System.out.println(maxGapIndices(A));
    }
}
