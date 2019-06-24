package xyz.liangxin.leetcode.practice.simple;

/**
 * 题目:
 *
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author liangxin
 */
public class BinaryTreeInversion {

    public static void main(String[] args){

        TreeNode treeNode=new TreeNode(4);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(7);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(3);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(9);
        showTree(treeNode);

    }


    public static TreeNode invertTree(TreeNode treeNode){

        return null;
    }

    public static void showTree(TreeNode treeNode){
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val+"----------"+treeNode.right.val);
    }

    public static void showTree2(TreeNode treeNode){

    }

    public static TreeNode createThreeNode(){
        return null;
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}
