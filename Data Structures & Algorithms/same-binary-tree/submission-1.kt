/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null) return q == null
        if (q == null) return false

        val pQueue = ArrayDeque<TreeNode>()
        val pDummy = TreeNode(0)
        pDummy.left = p
        pQueue.addLast(pDummy)

        val qQueue = ArrayDeque<TreeNode>()
        val qDummy = TreeNode(0)
        qDummy.left = q
        qQueue.addLast(qDummy)

        while(pQueue.isNotEmpty() || qQueue.isNotEmpty()) {
            val pNode = pQueue.removeFirstOrNull()
            val qNode = qQueue.removeFirstOrNull()
            if (pNode?.left?.`val` != qNode?.left?.`val` || pNode?.right?.`val` != qNode?.right?.`val`) return false
            pNode?.left?.let { pQueue.add(it) }
            pNode?.right?.let { pQueue.add(it) }
            qNode?.left?.let { qQueue.add(it) }
            qNode?.right?.let { qQueue.add(it) }
        }

        return true
    }

    fun <T> ArrayDeque<T>.removeFirstOrNull(): T? {
        return if (isEmpty()) {
            null
        } else {
            removeFirst()
        }
    }
}
