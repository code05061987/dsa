package test;

import dsa.two_pointer.Triplet;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Tushar Basantani
 */

public class TripletTest {

    int[][] input = {{12, 6, 1, 2, 7}, {1, 10, 3, 4, 19}, {1, 2, 3}};
    int[] output = {77,133,0};

    @Test
    public void test() {
        Triplet triplet = new Triplet();

        for(int i =0; i < input.length; i++){
            Assert.assertEquals(triplet.maximumTripletValue(input[i]), output[i]);
            Assert.assertEquals(triplet.maximumTripletValueFaster(input[i]), output[i]);
        }
    }
}
