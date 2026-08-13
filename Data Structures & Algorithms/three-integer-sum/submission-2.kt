class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val sortedNums = nums.clone()
        sortedNums.sort()
        for (i in 0..<sortedNums.size - 2) {
            val num = sortedNums[i]
            val twoSumResults = twoSum(sortedNums, i + 1, -num)
            twoSumResults.forEach { twoSumResult ->
                result.add(listOf(num, twoSumResult[0], twoSumResult[1]))
            }
        }
        return result.toList()
    }

    fun twoSum(numbers: IntArray, start: Int, target: Int): List<IntArray> {
        var left = start
        var right = numbers.size - 1
        val result = mutableListOf<IntArray>()
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum == target) {
                result.add(intArrayOf(numbers[left++], numbers[right--]))
            } else if (sum < target) {
                left++
            } else {
                right--
            }
        }
        return result
    }
}