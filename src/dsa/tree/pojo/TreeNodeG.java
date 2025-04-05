package dsa.tree.pojo;

/*
  @author Tushar Basantani
 */


public class TreeNodeG<T> {

    public T val;
    public TreeNodeG<T> left;
    public TreeNodeG<T> right;

    TreeNodeG() {}

    public TreeNodeG(T val) {this.val = val;}

    TreeNodeG(T val, TreeNodeG<T> left, TreeNodeG<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
