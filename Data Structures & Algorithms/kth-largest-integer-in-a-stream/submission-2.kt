class KthLargest(private val k: Int, nums: IntArray) {
    private val queue = PriorityQueue<Int>(nums.size.coerceAtLeast(1)) { a, b ->
        a - b
    }

    init {
        for ((index, num) in nums.withIndex()) {
            queue.add(num)
            if (index >= k) {
                queue.poll()
            }
        }
    }
    
    // 1,2,3,3,3,5,6,7,8

    fun add(`val`: Int): Int {
        queue.add(`val`)
        if (queue.size > k) {
            queue.poll()
        }
        return queue.peek()
    }
}
