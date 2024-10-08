package Arrays;

import java.util.Arrays;

public class ReverseArray {

    public int[] reverseArray(int[] nums) {

        int p1=0; int p2=nums.length-1;

        while(p1<p2){
            int temp=nums[p1];
            nums[p1]=nums[p2];
            nums[p2]=temp;
            p1++;
            p2--;
        }
        return nums;
    }

    public static void main(String[] args) {
        ReverseArray obj=new ReverseArray();
        int nums[]={1,2,3,4,5,6};
        System.out.println(Arrays.toString(obj.reverseArray(nums)));
    }
}
