package test;

import dsa.tree.util.BinaryTreeCreator;
import dsa.tree.pojo.TreeNode;
import dsa.tree.dfs.SumRootLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Tushar Basantani
 */

public class SumRootLeafTest {

    int[][] input = {{1,2,3}, {4,9,0,5,1}};
    int[] output = {25,1026};

    @Test
    public void test(){
        BinaryTreeCreator<Object> treeCreator = new BinaryTreeCreator<>();

        for(int i = 0; i < input.length; i++){
            TreeNode root = treeCreator.arrayToTree(input[i]);
            Assert.assertEquals(new SumRootLeaf().sumNumbers(root), output[i]);
        }
    }

}
