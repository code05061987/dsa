package test;

import dsa.top_k_elements.heap.PutMarblesInBag;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutMarblesInBagTest {

    @Test
    public void test(){
        PutMarblesInBag putMarblesInBag = new PutMarblesInBag();

        Assert.assertEquals(putMarblesInBag.putMarbles(new int[]{1,3,5,1}, 2), 4);
        Assert.assertEquals(putMarblesInBag.putMarbles(new int[]{1, 3}, 2), 0);
        Assert.assertEquals(putMarblesInBag.putMarbles(new int[]{1,4,2,5,2}, 3), 3);

        Assert.assertEquals(putMarblesInBag.putMarblesWitHeap(new int[]{1,3,5,1}, 2), 4);
        Assert.assertEquals(putMarblesInBag.putMarblesWitHeap(new int[]{1, 3}, 2), 0);
        Assert.assertEquals(putMarblesInBag.putMarblesWitHeap(new int[]{1,4,2,5,2}, 3), 3);


        Assert.assertEquals(putMarblesInBag.putMarblesPartialSort(new int[]{1,3,5,1}, 2), 4);
        Assert.assertEquals(putMarblesInBag.putMarblesPartialSort(new int[]{1, 3}, 2), 0);
        Assert.assertEquals(putMarblesInBag.putMarblesPartialSort(new int[]{1,4,2,5,2}, 3), 3);
    }


}
