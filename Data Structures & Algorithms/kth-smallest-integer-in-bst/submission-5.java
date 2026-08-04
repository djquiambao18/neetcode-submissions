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
    int steps = 0, result = 0;
    public int kthSmallest(TreeNode root, int k) {
        // dfsInorder
        dfsInorder(root, k);
        return result;
    }
    // no need to return anything, just need to traverse the tree
    // up to k
    private void dfsInorder(TreeNode node, int k) {
        // base-case: if the node is null OR steps are same as k
        if(node == null || steps >= k) {
            return;
        }
        // otherwise, explore the left-subtree
        dfsInorder(node.left, k);
        // increment steps bubble up
        steps++;
        // visit:
        if(steps == k) {
            result = node.val;
            return;
        }
        else {
            dfsInorder(node.right, k);
        }
    }
}
