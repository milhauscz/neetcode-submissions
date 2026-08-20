/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val levels = mutableListOf<List<Int>>()
        if (root == null) return levels

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level = mutableListOf<Int>()
            levels.add(level)
            repeat(levelSize) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }

        return levels
    }
}
