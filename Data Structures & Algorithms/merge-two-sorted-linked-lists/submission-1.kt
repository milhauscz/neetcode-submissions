/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        if (list1 == null && list2 == null) return null
        
        var curL1: ListNode? = list1
        var curL2: ListNode? = list2
        val res: ListNode?
        
        if (list1.`val` > list2.`val`) {
            val temp = curL1
            curL1 = curL2
            curL2 = temp
        }
        res = curL1

        while (curL1 != null && curL2 != null) {
            if (curL1!!.next == null || curL1!!.next!!.`val` > curL2!!.`val`) {
                val temp = curL1.next
                curL1.next = curL2
                curL1 = curL2
                curL2 = temp
            } else {
                curL1 = curL1.next
            }
        }
        return res
    }
}
