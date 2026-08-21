/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        var count = 0
        
        fun dfs(node: TreeNode?, max: Int) {
            if (node == null) return
            if (node.`val` >= max) {
                count++
            }
            val newMax = max(node.`val`, max)
            dfs(node.left, newMax)
            dfs(node.right, newMax)
        }

        dfs(root, root.`val`)
        return count
    }
}
