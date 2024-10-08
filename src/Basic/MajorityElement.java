package Basic;

import java.util.HashMap;

class Solution {
    public static int majorityElement(int[] nums) { // only space efficient
        HashMap<Integer,Integer> map = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){

            if( map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                map.put(nums[i],freq + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        int maxCount = 0;
        int maxVal = 0;
        for( int value : map.keySet() ){
            if( map.get(value) > maxCount && map.get(value) > nums.length/2 ){
                maxVal = value;
                maxCount = map.get(value);
            }
        }

        return maxVal;
    }

    public int majorityElementOpt(int[] nums) { // both time and space efficient
        int candidate = 0;
        int count = 0;

        // Step 1: Find the candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Verify the candidate (optional)
        // In most problems, it's guaranteed that a majority element exists,
        // so this step can be skipped. If not guaranteed, you should verify.
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // Optional verification step to ensure candidate is a majority element
        if (count > nums.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found");
        }
    }


    public static void main(String[] args) {
        int nums[] = {2,1,2,2,2,1,2,1};
        // int nums[] = {3,2,3};

        // System.out.println(majorityElement(nums));

        int n = 5;
        System.out.println(String.valueOf(5).length());
    }
}
