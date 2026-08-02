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
    int count = 0;
    int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        // kick off the traversal
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null || count >= k) return;
        
        inorder(root.left, k);
        
        // what should happen here, at the moment you "visit" root?
        // if we reach here, it means we are processing or visiting root.
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        else {
            inorder(root.right, k);
        }
    }
}
