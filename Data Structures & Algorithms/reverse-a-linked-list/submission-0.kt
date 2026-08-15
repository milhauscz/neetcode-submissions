/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val res = doReverseList(head)
        head?.next = null
        return res
    }

    fun doReverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next != null) {
            val res = reverseList(head.next!!)
            head.next!!.next = head
            return res
        } else {
            return head
        }
    }
}
