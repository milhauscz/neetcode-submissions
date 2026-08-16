/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val nodeToIndex = hashMapOf<Node,Int>()
        var cur = head
        var copy: Node? = cur?.let { Node(it.`val`) }
        val copyHead = copy
        val copyList = mutableListOf<Node>()
        copyHead?.let { copyList.add(it) }
        var i = 0
        while (cur != null) {
            nodeToIndex[cur] = i++
            copy?.next = cur?.next?.let { Node(it.`val`).also { copyList.add(it) } }
            copy = copy?.next
            cur = cur?.next
        }

        cur = head
        copy = copyHead
        while (cur != null) {
            cur?.random?.let {
                copy?.random = nodeToIndex[it]?.let { index ->
                    copyList[index]
                }
            }
            cur = cur?.next
            copy = copy?.next
        }
        return copyHead
    }
}
