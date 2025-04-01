package test;

import dsa.two_pointer.RemoveDuplicates;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Tushar Basantani
 */

public class RemoveDuplicatesTest {

    int[][] inputs = new int[][]{{1, 1, 1, 2, 2, 3}, {0, 0, 1, 1, 1, 1, 2, 3, 3}, {1, 2, 3, 4, 5, 6}};
    int[][] outputs = new int[][]{{1, 1, 2, 2, 3}, {0, 0, 1, 1, 2, 3, 3}, {1, 2, 3, 4, 5, 6}};

    @Test
    public void test() {
        for (int i = 0; i < inputs.length; i++) {
            int output = new RemoveDuplicates().removeDuplicates(inputs[i]);
            Assert.assertEquals(output, outputs[i].length, "The output value is not matching");

            int compare = Arrays.compare(inputs[i], 0, output, outputs[i], 0, output);
            Assert.assertEquals(compare, 0, "The output array is not matching");
        }

    }

}
