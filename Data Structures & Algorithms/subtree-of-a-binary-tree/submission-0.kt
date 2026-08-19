/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        if (isSubtreeDFS(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSubtreeDFS(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null && root == null) return true
        if (subRoot == null || root == null) return false
        if (root.`val` != subRoot.`val`) return false
        return isSubtreeDFS(root.left, subRoot.left) && isSubtreeDFS(root.right, subRoot.right)
    }
}
