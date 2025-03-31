package dsa.sliding_window;

/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * Topics
 * Companies
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinSizeSubarraySum {


    /*
    Explanation :

    * [2,3,1,2,4,3]
    * ||
    * [2,3,1,2,4,3]
    *  | |
    * [2,3,1,2,4,3]
    *  |   |
    * [2,3,1,2,4,3]
    *  |     |
    * found subarray with 4 size
    *
    * [2,3,1,2,4,3]
    *    |     |
    * found subarray with 4 size
    * [2,3,1,2,4,3]
    *      |   |
    * found subarray with 3 size
    *
    * [2,3,1,2,4,3]
    *        |   |
    * found subarray with 3 size
    *
    * [2,3,1,2,4,3]
    *          | |
    * found subarray with 2 size
    * [2,3,1,2,4,3]
    *            ||
    * [2,3,1,2,4,3]
    *            | |
    * */
    public int minSubArrayLen(int target, int[] nums) {
        int endIdx = 0;
        int startIdx = 0;
        int minArray = 0;

        int sum = 0;
        while(endIdx < nums.length){
            if(endIdx == startIdx){
                sum = nums[endIdx];
            }else{
                sum += nums[endIdx];
            }

            if(sum >= target){
                minArray = endIdx - startIdx + 1;
                if(minArray == 1){
                    return 1;
                }
                while (endIdx > startIdx){
                    sum -= nums[startIdx];
                    if(sum >= target){
                        minArray = endIdx - startIdx;
                        if(minArray == 1){
                            return 1;
                        }
                        startIdx++;
                    }else{
                        startIdx++;
                        endIdx++;
                        break;
                    }
                }

            }else{
                if(minArray > 0){
                    sum -= nums[startIdx];
                    startIdx++;
                }
                endIdx++;
            }

        }

        return minArray;
    }

}
