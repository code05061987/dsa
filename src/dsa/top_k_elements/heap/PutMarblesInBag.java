package dsa.top_k_elements.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2551. Put Marbles in Bags
You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.

Divide the marbles into the k bags according to the following rules:

No bag is empty.
If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
The score after distributing the marbles is the sum of the costs of all the k bags.

Return the difference between the maximum and minimum scores among marble distributions.



Example 1:

Input: weights = [1,3,5,1], k = 2
Output: 4
Explanation:
The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6.
The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10.
Thus, we return their difference 10 - 6 = 4.
Example 2:

Input: weights = [1, 3], k = 2
Output: 0
Explanation: The only distribution possible is [1],[3].
Since both the maximal and minimal score are the same, we return 0.


Constraints:

1 <= k <= weights.length <= 105
1 <= weights[i] <= 109
 */
public class PutMarblesInBag {

    public long putMarbles(int[] weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0L;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }


    public long putMarblesWitHeap(int[] weights, int k) {
        if (k == weights.length) return 0;

        int n = weights.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < n - 1; ++i) {
            int totalWeight = weights[i] + weights[i + 1];
            minHeap.add(totalWeight);
            maxHeap.add(totalWeight);
            if (maxHeap.size() > k - 1) {
                maxHeap.poll();
            }
        }

        long result = 0L;
        for (int i = 0; i < k - 1; i++) {
            result += maxHeap.poll() - minHeap.poll();
        }

        return result;
    }

    public long putMarblesPartialSort(int[] weights, int k) {
        if (k == weights.length) return 0;

        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        int[] maxVals = partialSort(pairWeights.clone(), k - 1, false);
        int[] minVals = partialSort(pairWeights, k - 1, true);


        long result = 0L;
        for (int i = 0; i < k - 1; i++) {
            result += maxVals[i] - minVals[i];
        }

        return result;
    }


    public int[] partialSort(int[] arr, int k, boolean isAsc) {
        quickSelect(arr, 0, arr.length - 1, k - 1, isAsc);
        int[] result = Arrays.copyOf(arr, k);
        Arrays.sort(result); // Sort only k elements
        return result;
    }

    private void quickSelect(int[] arr, int left, int right, int k, boolean isAsc) {
        if (left >= right) return;
        int pivotIndex = partition(arr, left, right, isAsc);
        if (k != pivotIndex) {
            if (k < pivotIndex) quickSelect(arr, left, pivotIndex - 1, k, isAsc);
            else quickSelect(arr, pivotIndex + 1, right, k, isAsc);
        }
    }

    private int partition(int[] arr, int left, int right, boolean isAsc) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (isAsc) {
                if (arr[j] <= pivot) {
                    swap(arr, i++, j);
                }
            } else {
                if (arr[j] >= pivot) {
                    swap(arr, i++, j);
                }
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
