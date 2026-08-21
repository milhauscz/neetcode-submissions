/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    fun isValidBST(root: TreeNode?, min: Int, max: Int): Boolean {
        if (root == null) return true
        if (root.`val` >= max || root.`val` <= min) return false
        return isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
    }
}
