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
        
        fun build(preorder: List<Int>, inorder: List<Int>): TreeNode? {
            if (preorder.isEmpty() || inorder.isEmpty()) return null
            // 1: 
            //preorder=[1,2,3,4]
            //inorder=[2,1,3,4]
            //node = TreeNode(1)
            //mid = 1
            //node.left = build(preorder = [2], inorder = [2])
            //node.right = build(preorder = [3, 4], inorder = [3, 4])
        
            val inorderValuesToIndices = hashMapOf<Int,Int>()
            for ((index, value) in inorder.withIndex()) {
                inorderValuesToIndices[value] = index
            }

            val node = TreeNode(preorder.first())
            val mid = inorderValuesToIndices[node.`val`]!!
            node.left = build(preorder.slice(1..mid), inorder.slice(0 until mid))
            node.right = build(preorder.slice(mid+1..preorder.lastIndex), inorder.slice(mid+1..inorder.lastIndex))
            return node
        }

        return build(preorder.toList(), inorder.toList())
    }
}
