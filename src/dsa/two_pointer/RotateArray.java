package dsa.two_pointer;

/**
 * 189. Rotate Array
 * <p>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class RotateArray {

    public void rotateSlower(int[] nums, int k) {
        int size = nums.length;
        if (size == k || k == 0) {
            return;
        }

        if (k > size) {
            k = k % size;
        }

        int startIdx = 0;
        int idx = 0;
        int num = nums[0];
        for (int i = 0; i < size; i++) {
            int newIdx = idx + k;
            if (newIdx > size - 1) {newIdx = newIdx - size;}
            int temp = nums[newIdx];
            nums[newIdx] = num;
            num = temp;
            if (newIdx == startIdx) {
                newIdx++;
                if (newIdx >= size) {
                    newIdx = 0;
                }
                startIdx = newIdx;
                num = nums[newIdx];
            }
            idx = newIdx;
        }
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    /*
    Explanation:

        {1, 2, 3, 4, 5, 6, 7}
        reverse the complete Array
        {7, 6, 5, 4, 3, 2, 1}

        reverse 2 parts - part 1 - first k elements, part 2 - total - k
        {7, 6, 5,    4, 3, 2, 1}
        reverse part 1
        {5, 6, 7,    4, 3, 2, 1}
        reverse part 2
        {5, 6, 7,    1, 2, 3, 4}

     */

    public void rotate(int[] nums, int k) {
        int part2 = k % nums.length;
        if(k < 0) part2 += nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,part2-1);
        reverse(nums,part2,nums.length-1);
    }

}
