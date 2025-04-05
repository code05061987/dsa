package dsa.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
57. Insert Interval

* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
* */

public class InsertInterval {


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)

        Explanation :

        1. Create new List for output as the size can be variable. Inplace is not possible
        2. Iterate through intervals and add non-overlapping intervals before newInterval
        3. Merge overlapping intervals into the newInterval
        4. Add merged newInterval
        5. Add non-overlapping intervals after newInterval
     */
    public int[][] insertWithInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // Iterate through intervals and add non-overlapping intervals before newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        result.add(newInterval);

        // Add non-overlapping intervals after newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)

        Explanation :
        Naive approach with many if else conditions.

     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ints = new int[intervals.length + 1][];

        int track = 0;
        boolean copyRemaining = false;
        boolean didMerge = false;
        for (int[] interval : intervals) {
            if (copyRemaining) {
                ints[track++] = interval;
                continue;
            }

            int f = interval[0];
            int s = interval[1];

            if (newInterval[1] < f) {
                ints[track++] = newInterval;
                ints[track++] = interval;
                copyRemaining = true;
            } else if (newInterval[0] > s) {
                ints[track++] = interval;
            } else {
                ints[track++] = new int[]{Math.min(f, newInterval[0]), Math.max(s, newInterval[1])};
                didMerge = true;
                break;
            }
        }

        if (didMerge) {
            for (int i = track; i < intervals.length; i++) {
                if (intervals[i][0] > ints[track - 1][1]) {
                    ints[track++] = intervals[i];
                } else {
                    ints[track - 1][1] = Math.max(ints[track - 1][1], intervals[i][1]);
                }
            }

            return Arrays.copyOfRange(ints, 0, track);
        } else if (!copyRemaining) {
            ints[track] = newInterval;
        }

        return ints;
    }


}
