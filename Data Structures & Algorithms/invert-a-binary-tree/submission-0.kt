/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val first = queue.removeFirst()!!
            val temp = first.left
            first.left = first.right
            first.right = temp
            first.left?.let { queue.addLast(it) }
            first.right?.let { queue.addLast(it) }
        }

        return root
    }
}
