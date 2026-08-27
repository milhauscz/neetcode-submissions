class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(stones.size) { a, b ->
            b - a
        }
        maxHeap.addAll(stones.toMutableList())
        while (maxHeap.size > 1) {
            val a = maxHeap.poll()
            val b = maxHeap.poll()
            if (a != b) {
                val smashed = abs(a - b)
                maxHeap.add(smashed)
            }
        }
        return if (maxHeap.isEmpty()) 0 else maxHeap.poll()
    }
}
