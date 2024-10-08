package Arrays;

//Given a non-empty array, return true if there is a place to split
// the array so that the sum of the numbers on one side is equal
// to the sum of the numbers on the other side.
//
//
//        canBalance([1, 1, 1, 2, 1]) → true
//        canBalance([2, 1, 1, 2, 1]) → false
//        canBalance([10, 10]) → true

public class CanBalance {

    public boolean canBalance(int nums[]){

        if(nums.length<=1){
            return false;
        }


        else if(nums.length>2) {
            for (int i = 1; i < nums.length; i++) {
                int suml = 0;
                int sumr = 0;
                for (int j = i - 1; j >= 0; j--) {
                    suml += nums[j];
                }
                for (int k = i; k < nums.length; k++) {
                    sumr += nums[k];
                }

                if (suml == sumr) {
                    return true;
                }
            }
        } else if (nums.length==2) {
            if(nums[0]==nums[1]){
                return true;
            }
        }


        return false;

    }

    public static void main(String[] args) {
        CanBalance obj=new CanBalance();
        int nums[]={1,1,1,2,1};
        //int nums[]={10,10};
        System.out.println(obj.canBalance(nums));
    }
}
