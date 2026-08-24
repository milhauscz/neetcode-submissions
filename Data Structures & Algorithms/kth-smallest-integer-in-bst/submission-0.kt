/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var count = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1
        val res = root.left?.let { kthSmallest(it, k) }
        return if (res != null && res != -1) {
            res
        } else if (++count == k)  {
            root.`val`
        } else {
            root.right?.let { kthSmallest(it, k) } ?: -1
        }
    }
}
