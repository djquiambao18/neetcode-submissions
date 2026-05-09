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
        Queue<TreeNode> bfs = new ArrayDeque<TreeNode>();
        bfs.offer(p);
        bfs.offer(q);
        while(!bfs.isEmpty()) {
            TreeNode p1 = bfs.poll();
            TreeNode q1 = bfs.poll();
            // System.out.printf("p1 %s, q1 %s\n", p1.val, q1.val);
            if(p1 == null && q1 == null) {
                return true;
            }
            else if(p1 == null || q1 == null 
            || (p1.left == null && q1.left != null)
            || (p1.right == null && q1.right != null) 
            || (p1.left != null && q1.left == null)
            || (p1.right != null && q1.right == null)
            || p1.val != q1.val) {
                return false;
            }
            if(p1.left != null && q1.left != null) {
                bfs.offer(p1.left);
                bfs.offer(q1.left);
            }
            if(p1.right != null && q1.right != null) {
                bfs.offer(p1.right);
                bfs.offer(q1.right);
            }
        }
        System.out.println("Reached here");
        return true;
    }
}
