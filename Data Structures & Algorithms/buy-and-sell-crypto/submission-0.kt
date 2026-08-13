class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = prices.last()
        var maxProfit = 0
        prices.reversed().forEach {
            val profit = max - it
            maxProfit = max(maxProfit, profit)
            max = max(it, max)
        }
        return maxProfit
    }
}
