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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // consider the property of BST
        // every node to the LEFT of the current node < itself
        // and every node to the RIGHT is >= itself
        /*
            Start at 'root'
            Compare 'p.val' and 'q.val' to 'root.val'
            If both are less -> move root to root.left
            If both are greater -> move root to root.right
            Otherwise -> return root
        */
        // if(q.val < root.val && p.val < root.val) {
        //     return lowestCommonAncestor(root.left, p, q);
        // }
        // else if(q.val > root.val && p.val > root.val) {
        //     return lowestCommonAncestor(root.right, p, q);
        // }
        // return root;
        TreeNode temp = root;
        // check the tree until we've exhausted it
        while(temp != null) {
            // check the left-subtree:
            if(q.val < temp.val && p.val < temp.val) {
                temp = temp.left;
            }
            // check the right-subtree:
            else if(q.val > temp.val && p.val > temp.val) {
                temp = temp.right;
            }
            else {
                break;
            }
        }
        return temp;
    }
}
