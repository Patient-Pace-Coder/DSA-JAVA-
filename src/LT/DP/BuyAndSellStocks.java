package LT.DP;

import java.util.Arrays;

public class BuyAndSellStocks {

    private static int buyAndSellStocks( int arr[] ){ // TLE

        int dp[] = new int[arr.length]; // we can solve it using 2D dp matrix too
        dp[0] = 0;
        int maxProfit = 0;
        for( int i = 0; i < arr.length; i++ ){
            for( int j = i + 1; j < arr.length; j++ ){
                if( i == 0 && j == 0 ){
                    continue;
                }else if( arr[j] < maxProfit ){ // from observation of dp table
                    continue;
                }
                else{
                    if( arr[i] < arr[j] ) {
                        dp[i] = Math.max(dp[i], arr[j] - arr[i]);
                        maxProfit = Math.max(dp[i],maxProfit);
                    }
                }
            }
        }

        return maxProfit;
    }

    private static int buyAndSellStocksOpt( int prices[] ){ // TLE : 202/212 testcases passed
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp[] = new int[prices.length]; // we can solve it using 2D dp matrix too
        dp[0] = 0;
        int minPrice = prices[0];
        for( int i = 1; i < prices.length; i++ ){
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(prices[i],minPrice);
            // System.out.println(Arrays.toString(dp));
        }

        return dp[prices.length - 1];
    }

    public static void main(String[] args) {

        // int arr[] = {1,2,3,4,5,6};
        int arr[] = {7,1,5,3,6,4}; // 5
        // int arr[] = {7,6,4,3,1}; // 0

        System.out.println(buyAndSellStocksOpt(arr));
    }
}
