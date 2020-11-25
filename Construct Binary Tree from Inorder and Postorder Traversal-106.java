// Problem link
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

import java.util.*;

class Solution {
    public static int key;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        key = inorder.length-1;
        for(int i = inorder.length-1; i >= 0; i--)
            map.put(inorder[i], i);

        TreeNode head = makeTree(postorder, inorder, 0, postorder.length-1);
        return head;
    }

    private TreeNode makeTree(int[] postorder, int[] inorder, int left, int right) {
        if(left > right)
            return null;
        
        TreeNode curr = new TreeNode(postorder[key]);
        int index = map.get(postorder[key]);
        key--;

        curr.left = makeTree(postorder, inorder, index+1, right);
        curr.right = makeTree(postorder, inorder, left, index-1);
        
        return curr;
    }
}

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