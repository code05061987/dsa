package dsa.two_pointer;

/**
 * 2873. Maximum Value of an Ordered Triplet I
 * 2874. Maximum Value of an Ordered Triplet II
 * <p>
 * You are given a 0-indexed integer array nums.
 * <p>
 * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
 * <p>
 * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,6,1,2,7]
 * Output: 77
 * Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
 * It can be shown that there are no ordered triplets of indices with a value greater than 77.
 * Example 2:
 * <p>
 * Input: nums = [1,10,3,4,19]
 * Output: 133
 * Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
 * It can be shown that there are no ordered triplets of indices with a value greater than 133.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 106
 */

public class Triplet {


    /*
    Explanation :
    - Go over all possible combinations and find the max
     */
    public long maximumTripletValue(int[] nums) {
        long result = 0L;
        int a = 0;
        int b = 1;
        int c = 2;

        for (int k = c; k < nums.length; k++) {
            for (int j = b; j < k; j++) {
                for (int i = a; i < j; i++) {
                    long val = (nums[i] - nums[j]) * (long)nums[k];
                    result = Math.max(val, result);
                }
            }
        }
        return result;
    }

    /*
    Explanation :
    - Keep track of the maxDiff and the maxElement
        maxTriplet =0, maxDiff=0,maxElement=0
        i=0, 12,6,1,2,7
        maxTriplet =0, maxDiff=0,maxElement=12
        i=1, 12,6,1,2,7
        maxTriplet =0, maxDiff=6,maxElement=12
        i=2, 12,6,1,2,7
        maxTriplet =6, maxDiff=11,maxElement=12
        i=3, 12,6,1,2,7
        maxTriplet =22, maxDiff=11,maxElement=12
        i=4, 12,6,1,2,7
        maxTriplet =77, maxDiff=11,maxElement=12
     */
    public long maximumTripletValueFaster(int[] nums) {
        long maxTriplet = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxElement - num);
            maxElement = Math.max(maxElement, num);
        }
        return maxTriplet;
    }

}
