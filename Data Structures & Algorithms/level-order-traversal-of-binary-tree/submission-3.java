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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) {
            q.offer(root);
            // could we utilize the property of base 2 powers (binary)
            int n = q.size();
            // loops here, outer loop condition is when queue is empty
            // inner for-loop will use the precalculated queue size before it
            while(!q.isEmpty()) {
                n = q.size();
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < n && q.peek() != null; i++) {
                    TreeNode curr = q.poll();
                    // insert into list:
                    list.add(curr.val);
                    if(curr.left != null) {
                        q.offer(curr.left);
                    }
                    if(curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                result.add(list);
                n++;
            }
        }
        return result;
    }
}
