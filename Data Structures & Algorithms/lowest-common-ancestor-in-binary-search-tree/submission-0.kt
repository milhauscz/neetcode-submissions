/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        
        val pPath = findPathToNode(root, p)
        val qPath = findPathToNode(root, q)
        
        val trimmedPath = if (pPath.size > qPath.size) {
            pPath
        } else {
            qPath
        }
        repeat(abs(pPath.size - qPath.size))  {
            trimmedPath.removeLast()
        }

        var curP: TreeNode? = null
        var curQ: TreeNode? = null
        do {
            curP = pPath.removeLast()
            curQ = qPath.removeLast()
        } while (curP != curQ)
        return curP
    }

    fun findPathToNode(root: TreeNode, node: TreeNode): ArrayDeque<TreeNode> {
        var cur: TreeNode? = root
        val path = ArrayDeque<TreeNode>()
        while (cur != node) {
            if (cur == null) throw IllegalStateException("cur must not be null")
            path.add(cur)
            if (cur.`val` > node.`val`) {
                cur = cur.left
            } else {
                cur = cur.right
            }
        }
        path.add(node)
        return path
    }
}
