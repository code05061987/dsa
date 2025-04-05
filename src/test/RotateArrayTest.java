package test;

import dsa.two_pointer.RotateArray;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Tushar Basantani
 */

public class RotateArrayTest {

    int[][] input = {{1, 2, 3, 4, 5, 6, 7}, {-1, -100, 3, 99}, {-1}, {1, 2}};
    int[] rotateIdx = {3, 2, 2, 3};
    int[][] output = {{5, 6, 7, 1, 2, 3, 4}, {3, 99, -1, -100}, {-1}, {2, 1}};

    @Test
    public void test() {
        RotateArray rotateArray = new RotateArray();
        for (int i = 0; i < input.length; i++) {
            int[] cloneInput = input[i].clone();
            rotateArray.rotate(cloneInput, rotateIdx[i]);
            Assert.assertEquals(cloneInput, output[i]);

            rotateArray.rotate(input[i], rotateIdx[i]);
            Assert.assertEquals(input[i], output[i]);
        }

    }

}
