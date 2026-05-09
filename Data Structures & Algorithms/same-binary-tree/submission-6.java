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
        // iterative BFS:
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        // Should result in O(p+q), which collapses into O(n) space complexity & time complexity
        Queue<TreeNode> bfs = new LinkedList<TreeNode>(); //LinkedList queue allows for null values
        // ArrayDeque doesnt.
        bfs.offer(p);
        bfs.offer(q);
        while(!bfs.isEmpty()) {
            TreeNode p1 = bfs.poll();
            TreeNode q1 = bfs.poll();
            if(p1 == null && q1 == null) {
                continue; //skips this iteration, explores other nodes in the queue/tree
            }
            if(p1 == null || q1 == null || p1.val != q1.val) {
                return false;
            }
            bfs.offer(p1.left);
            bfs.offer(q1.left);
            bfs.offer(p1.right);
            bfs.offer(q1.right);
        }
        return true;
    }
}
