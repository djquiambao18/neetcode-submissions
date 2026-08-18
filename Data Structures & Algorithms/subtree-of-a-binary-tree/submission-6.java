/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(subRoot == null)
            return true;
        // if(root == null && subRoot == null)
        //     return true;
        return sameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // level order traversal / bfs:

    // same tree
    private boolean sameTree(TreeNode tree, TreeNode subTree) {
        if(tree == null && subTree == null) {
            return true;
        }
        if(tree == null || subTree == null || tree.val != subTree.val) {
            return false;
        }
        return sameTree(tree.left, subTree.left) && sameTree(tree.right, subTree.right);
    }

}
