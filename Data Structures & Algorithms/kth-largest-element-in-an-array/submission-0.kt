class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>(k + 1)
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.size > k) minHeap.poll()
        }
        return minHeap.peek()
    }
}
