package Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {

    private static int singleNumber( int nums[] ){ // time efficient

        HashMap<Integer,Integer> myArr = new HashMap<>();

        for( int i = 0 ; i < nums.length; i++ ){
            if( !myArr.containsKey(nums[i]) ){
                myArr.put(nums[i],1);
            }
            else if( myArr.containsKey(nums[i]) ){
                int freq = myArr.get(nums[i]);
                myArr.put(nums[i],freq+1);
            }
        }

        for( int ele : myArr.keySet() ){
            if( myArr.get(ele) == 1 ){
                return ele;
            }
        }
        return -1;
    }


    private static int singleNumberAlt( int nums[] ){ // memory efficient

        Arrays.sort(nums);
        int i = 0;
        for( i = 0 ; i < nums.length - 1; i++ ){
            if( nums[i] == nums[i + 1] ){
                i++;
            }else{
                return nums[i];
            }
        }
        if( i < nums.length ){
            return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {1,2,2,4,5,4,1};

        // {1,1,2,2,4,4,5,5}
        System.out.println(singleNumberAlt(nums));

    }
}
