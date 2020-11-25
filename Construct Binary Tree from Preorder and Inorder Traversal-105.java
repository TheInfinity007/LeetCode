// Problem link
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


class Solution {

    public static int key = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        if(preorder.length < 1)
            return null;

        TreeNode head = makeTree(preorder, inorder, 0, preorder.length-1);
        return head;
    }

    private TreeNode makeTree(int[] preorder, int[] inorder, int left, int right) {
        if(left > right)
            return null;

        TreeNode curr = new TreeNode(preorder[key]);
        int index = find(inorder, preorder[key], left, right);
        key++;
        curr.right = makeTree(preorder, inorder, left, index-1);
        curr.left = makeTree(preorder, inorder, index+1, right);
        return curr;
    }

    private int find(int[] inorder, int key, int left, int right) {
        for(int i = left; i <= right; i++){
            if(inorder[i] ==  key)
                return i;
        }
        return -1;
    }
}



/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}