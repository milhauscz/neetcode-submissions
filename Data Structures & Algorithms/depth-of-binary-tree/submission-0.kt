/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val stack = ArrayDeque<Pair<TreeNode,Int>>()
        stack.addLast(root to 1)

        var maxDepth = 0
        while (stack.isNotEmpty()) {
            val (node, currentDepth) = stack.removeLast()
            maxDepth = max(maxDepth, currentDepth)
            node.left?.let { stack.addLast(it to currentDepth + 1) }
            node.right?.let { stack.addLast(it to currentDepth + 1) }
        }

        return maxDepth
    }
}
