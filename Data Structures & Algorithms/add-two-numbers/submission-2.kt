/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1
        

        val l1Count = countList(l1)
        val l2Count = countList(l2)
        
        val short: ListNode?
        val long: ListNode?
        if (l1Count > l2Count) {
            long = l1
            short = l2
        } else {
            long = l2
            short = l1
        }

        var cur: ListNode? = long        
        var curShort = short
        while (cur != null && curShort != null) {
            cur.`val` += (curShort.`val` ?: 0)
            cur = cur.next
            curShort = curShort.next
        }

        cur = long
        var prev: ListNode? = null
        var overFlow = 0
        while (cur != null) {
            cur.`val` += overFlow
            if (cur.`val` >= 10) {
                overFlow = 1
                cur.`val` -= 10
            } else {
                overFlow = 0
            }
            prev = cur
            cur = cur?.next
        }
        if (overFlow == 1) {
            prev?.next = ListNode(1)
        }

        return long
    }

    private fun reverseAndCountList(node: ListNode): Int {
        var cur: ListNode? = node
        var prev: ListNode? = null
        var count = 0
        while (cur != null) {
            count++
            val tempNext = cur.next
            cur.next = prev
            prev = cur
            cur = tempNext
        }
        return count
    }

    private fun countList(node: ListNode): Int {
        var cur: ListNode? = node
        var count = 0
        while (cur != null) {
            count++
            cur = cur.next
        }
        return count
    }
}
