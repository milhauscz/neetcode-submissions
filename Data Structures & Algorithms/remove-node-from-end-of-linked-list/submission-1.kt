/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var count = 0
        var cur = head
        while (cur != null) {
            count++
            cur = cur?.next
        }

        val pos = count - n + 1

        if (pos == 1) return head?.next

        var i = 1
        cur = head
        while (i != pos - 1) {
            cur = cur?.next
            i++
        }
        cur?.next = cur?.next?.next
        return head
    }
}
