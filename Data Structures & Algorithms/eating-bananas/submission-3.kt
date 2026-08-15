class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var sum: Long = 0
        piles.sortDescending()
        for (pile in piles) {
            sum += pile
        }
        var left = ((sum + h - 1) / h).toInt()
        var right = piles[0]
        var res = 0
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canEatInTime(mid, piles, h)) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return res
    }

    fun canEatInTime(k: Int, piles: IntArray, h: Int): Boolean {
        var time: Long = 0
        for (pile in piles) {
            time += (pile + k - 1) / k
            if (time > h) return false
        }
        return true
    }
}
