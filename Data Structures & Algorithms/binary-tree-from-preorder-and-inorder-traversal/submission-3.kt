/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null
        
        val inorderValuesToIndices = hashMapOf<Int,Int>()
        for ((index, value) in inorder.withIndex()) {
            inorderValuesToIndices[value] = index
        }

        var preIndex = 0

        fun build(inStart: Int, inEnd: Int): TreeNode? {
            if (inStart >= inEnd) return null            
            val node = TreeNode(preorder[preIndex++])
            val mid = inorderValuesToIndices[node.`val`]!!
            node.left = build(inStart, mid)
            node.right = build(mid+1, inEnd)
            return node
        }

        return build(0, preorder.size)
    }
}
