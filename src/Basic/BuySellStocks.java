package Basic;

import java.util.Arrays;

public class BuySellStocks {

    private static int buySellStocks( int nums[] ){ // basic but exceeds time for larger inputs
        int profit = 0;
        for( int i = 0; i < nums.length; i++ ) {
            for (int j = nums.length - 1; j > i; j--) {
                int diff = nums[j] - nums[i];
                if (diff > 0) {
                    profit = Math.max(diff, profit);
                    // System.out.println("i:"+i+","+"j:"+j+" profit : "+profit);
                }
            }
        }
        return profit;
    }

    private static int buySellStocksRec( int nums[],int profit ){ // basic but exceeds time for larger inputs

        return profit;
    }



    public static void main(String[] args) {

        int nums[] = {7,1,5,6,8,3};

        System.out.println(buySellStocks(nums));
    }
}
