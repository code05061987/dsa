package test;

import dsa.sliding_window.MinSizeSubarraySum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DSATest {

    @Test
    public void test() {
        MinSizeSubarraySum minSizeSubarraySum = new MinSizeSubarraySum();
        Assert.assertEquals(minSizeSubarraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        Assert.assertEquals(minSizeSubarraySum.minSubArrayLen(4, new int[]{1, 4, 4}), 1);
        Assert.assertEquals(minSizeSubarraySum.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), 0);
        Assert.assertEquals(minSizeSubarraySum.minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}), 2);
        Assert.assertEquals(minSizeSubarraySum.minSubArrayLen(6, new int[]{10, 2, 3}), 1);
    }

}
