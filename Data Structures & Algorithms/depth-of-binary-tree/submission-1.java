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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // Queue<TreeNode> bfs = new ArrayDeque<>();
        // int max = 0;
        // // enqueue:
        // bfs.offer(root);
        // while(bfs.peek() != null) {
        //     TreeNode curr = bfs.poll();
        //     if(curr != null) {
        //         max++;
        //     }
        //     if(curr.left != null)
        //         bfs.offer(curr.left);
        //     if(curr.right != null)
        //         bfs.offer(curr.right);
        // }

        // check left side depth:
        // if(root.left != null && root.right == null) {
        //     return maxDepth(root.left) + 1;
        // }
        // else if (root.right != null && root.left == null) {
        //     return maxDepth(root.right) + 1;
        // }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
