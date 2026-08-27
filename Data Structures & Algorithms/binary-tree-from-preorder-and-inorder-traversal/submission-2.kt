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

        fun build(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
            if (preStart >= preEnd || inStart >= inEnd) return null
            // 1: 
            //preorder=[1,2,3,4]
            //inorder=[2,1,3,4]
            //node = TreeNode(1)
            //mid = 1
            //node.left = build(preorder = [2], inorder = [2])
            //node.right = build(preorder = [3, 4], inorder = [3, 4])
        
            val node = TreeNode(preorder[preStart])
            val mid = inorderValuesToIndices[node.`val`]!!
            val len = mid - inStart
            //node.left = build(preorder.slice(1 until mid + 1), inorder.slice(0 until mid))
            //node.right = build(preorder.slice(mid+1 until preorder.size), inorder.slice(mid+1 until inorder.size))
            node.left = build(preStart + 1, preStart+len+1, inStart, mid)
            node.right = build(preStart+len+1, preEnd, inStart+len+1, inEnd)
            return node
        }

        return build(0, preorder.size, 0, preorder.size)
    }
}
