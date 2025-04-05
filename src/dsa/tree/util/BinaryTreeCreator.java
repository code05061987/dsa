package dsa.tree.util;

import dsa.tree.pojo.TreeNode;
import dsa.tree.pojo.TreeNodeG;

/**
 * Helper class to generate TreeNode from array input
 */

public class BinaryTreeCreator<T> {

    public TreeNodeG<T> arrayToTree(T[] input) {
        return createTreeNode(input, 1);
    }

    private TreeNodeG<T> createTreeNode(T[] input, int index) {
        if (index <= input.length) {
            T value = input[index - 1];
            if (value != null) {
                TreeNodeG<T> t = new TreeNodeG<T>(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    public TreeNode arrayToTree(int[] input) {
        return createTreeNode(input, 1);
    }

    private TreeNode createTreeNode(int[] input, int index) {
        if (index <= input.length) {
            int value = input[index - 1];
            TreeNode t = new TreeNode(value);
            t.left = createTreeNode(input, index * 2);
            t.right = createTreeNode(input, index * 2 + 1);
            return t;
        }
        return null;
    }

}
