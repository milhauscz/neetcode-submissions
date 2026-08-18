/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        calculateDiameter(root)
        return diameter
    }

    fun calculateDiameter(root: TreeNode?): Int {
        if (root == null) return 0
        val depthLeft = calculateDiameter(root.left)
        val depthRight = calculateDiameter(root.right)
        val subDepth = depthLeft + depthRight
        diameter = max(diameter, subDepth)
        return 1 + max(depthLeft, depthRight)
    }
}
