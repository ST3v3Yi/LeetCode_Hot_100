package LeetCode.Day16.Q121;

import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        for (int price : prices) {
            minPrice = (minPrice < price) ? minPrice : price;
            maxPrice = (maxPrice > price - minPrice) ? maxPrice : price - minPrice;
        }
        return maxPrice;
    }
}
