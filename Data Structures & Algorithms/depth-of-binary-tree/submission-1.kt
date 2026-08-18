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

        var currentLevelQueue = ArrayDeque<TreeNode>()
        var nextLevelQueue = ArrayDeque<TreeNode>()
        currentLevelQueue.addFirst(root)
        var currentDepth = 1
        var maxDepth = 1

        while (currentLevelQueue.isNotEmpty() || nextLevelQueue.isNotEmpty()) {
            if (currentLevelQueue.isEmpty()) {
                var temp = currentLevelQueue
                currentLevelQueue = nextLevelQueue
                nextLevelQueue = temp
                maxDepth = max(maxDepth, ++currentDepth)
            }

            val node = currentLevelQueue.removeLast()
            node.left?.let { nextLevelQueue.add(it) }
            node.right?.let { nextLevelQueue.add(it) }
        }

        return maxDepth
    }
}
