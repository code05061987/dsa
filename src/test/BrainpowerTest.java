package test;

import dsa.dp.Brainpower;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Tushar Basantani
 */

public class BrainpowerTest {

    int[][][] inputs = {{{3, 2}, {4, 3}, {4, 4}, {2, 5}}, {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}},{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}}};

    int[] outputs = {5, 7, 157};

    @Test
    public void test() {
        Brainpower brainpower = new Brainpower();
        int i = 0;
        for (int[][] array : inputs) {
            Assert.assertEquals(brainpower.mostPoints(array), outputs[i]);
            i++;
        }

    }

}
