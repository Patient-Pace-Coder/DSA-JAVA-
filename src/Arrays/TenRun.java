package Arrays;

//For each multiple of 10 in the given array, change all the values following it to be that multiple of 10,
// until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
//
//
//        tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
//        tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
//        tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]

import java.util.Arrays;

public class TenRun {

    public int[] tenRun(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%10==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]%10!=0){
                        nums[j]=nums[i];
                    }
                    else{
                        i=j-1;   // to not skip the current element which is a multiple of 10
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        TenRun obj=new TenRun();
        int nums[]={1,20,5,50,0,1};
        System.out.println(Arrays.toString(obj.tenRun(nums)));
    }


}
