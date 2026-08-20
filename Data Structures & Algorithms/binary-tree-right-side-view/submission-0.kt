/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val vals = mutableListOf<Int>()
        
        fun dfs(node: TreeNode?, depth: Int) {
            if (node == null) return
            if (depth > vals.size) {
                vals.add(node.`val`)
            }
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        }

        dfs(root, 1)
        return vals
    }
}
