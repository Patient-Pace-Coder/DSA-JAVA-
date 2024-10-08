package Recursion.SubsetSubsequenceStringQtns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfArray {

    // iteration approach

//                            [1,2,3] initial array
//                               |
//                            [ [] ]
//                               |
//                            [ [] , [1] ]->outer array  , [] , [1]---inner arrays   (num=1)
//                                |
//                            [ [] , [1] , [2] , [1,2] ] --------------------------->(num=2)
//                                |
//                            [ [] , [1] , [2] , [1,2] , [3] , [1,3] , [2,3] , [1,2,3] ]-->(num=3)

    public static List<List<Integer>> subset(int[] arr){

        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>()); // creation of outer array

        for(int num: arr){
            int n= outer.size();

            for(int i=0;i<n;i++){
                List<Integer> inner=new ArrayList<>(outer.get(i)); // we take the existing elements of outer list and just add num to them i.e. if num=1, i=0,
                // then we take the 0th element of outer i.e. [] as inner array and add 1 to it then add inner to outer so outer becomes [],[1,2]
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }


    // iteration approach with duplicate elements

//                            [1,2,2] initial array
//                               |
//                            [ [] ]
//                               |
//                            [ [] , [1] ]->outer array  , [] , [1]---inner arrays   (num=1)
//                                |
//                            [ [] , [1] , [2] , [1,2] ] --------------------------->(num=2)
//                                |
//                            [ [] , [1] , [2] , [1,2] , [2] , [1,2] , [2,2] , [2,1,2] ]-->(num=3)

//                          here we can see that [2] [1,2] is repeated twice. this is the problem so to solve this we use an approach
//     intuition : when you find a duplicate element, only add it in the newly created subset of previous step. To solve this problem we must sort the array, then proceed.


    public static List<List<Integer>> subsetDuplicate(int[] arr){

        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>()); // creation of outer array

        int start = 0;
        int end = 0;
        for(int i=0;i<arr.length;i++){

            start = 0;
            // if current and previous elements are same, s=e+1
            if (i>0 && arr[i] == arr[i-1]){
                start = end+1; // we skip the first 2 elements i.e. ([],[1]) here as it will result in duplicating lists
            }
            end= outer.size()-1;
            int n= outer.size();
            for(int j=start;j<n;j++){
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }

    public static void main(String[] args) {

       List<List<Integer>> ans=subset(new int[]{1,2,3});

        // List<List<Integer>> ans = subsetDuplicate(new int[] {1,2,2});

        for(List<Integer> list : ans ){

            System.out.println(list);
        }
    }
}
