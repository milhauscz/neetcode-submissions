class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>(k + 1) { a, b ->
            val aDistEst = a[0] * a[0] + a[1] * a[1]
            val bDistEst = b[0] * b[0] + b[1] * b[1]
            bDistEst - aDistEst
        }
        for (point in points) {
            maxHeap.add(point)
            if (maxHeap.size > k) maxHeap.poll()
        }
        val res = Array<IntArray>(k) { 
            maxHeap.poll()            
        }
        return res
    }
}
