/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        var balanced = true

        fun maxDepth(root: TreeNode?): Int {
            if (root == null || !balanced) return 0
            val leftDepth = maxDepth(root.left)
            if (!balanced) return 0
            val rightDepth = maxDepth(root.right)
            if (abs(leftDepth - rightDepth) > 1) balanced = false
            return 1 + max(leftDepth, rightDepth)
        }

        maxDepth(root)
        return balanced
    }
}
