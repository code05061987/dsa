package test;

import dsa.interval.InsertInterval;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InsertIntervalTest {
    int[][][] inputInterval = {{{1, 3}, {6, 9}}, {{1, 4}}, {{5, 6}, {7, 8}}, {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}};
    int[][] newInterval = {{2, 5}, {5, 6}, {1, 4}, {4, 8}};

    int[][][] out = {{{1, 5}, {6, 9}}, {{1, 4}, {5, 6}}, {{1, 4}, {5, 6}, {7, 8}}, {{1, 2}, {3, 10}, {12, 16}}};

    @Test
    public void test() {
        InsertInterval insertInterval = new InsertInterval();


        for (int i = 0; i < inputInterval.length; i++) {
            int[][] actual = insertInterval.insert(inputInterval[i], newInterval[i]);
            Assert.assertEquals(actual, out[i]);

            actual = insertInterval.insertWithInterval(inputInterval[i], newInterval[i]);
            Assert.assertEquals(actual, out[i]);
        }
    }

}
