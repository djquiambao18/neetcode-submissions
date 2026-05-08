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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if((p == null && q != null) || (p != null && q == null))
            return false;
        if((p.left != null && q.left != null && p.left.val != q.left.val) 
            || 
            p.right != null && q.right != null && p.right.val != q.right.val 
          ) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (q.val == p.val);
    }
}
