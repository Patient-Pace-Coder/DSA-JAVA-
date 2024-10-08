package Basic;

public class containsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        int num = nums[0];
        for( int i = 1; i < nums.length - 1; i++ ){
            num = num^nums[i];
            if( num == 0 ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};

        System.out.println(containsDuplicate(nums));
    }
}
