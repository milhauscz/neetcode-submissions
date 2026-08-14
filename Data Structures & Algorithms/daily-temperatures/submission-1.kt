class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val decreasingTempIndicesStack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for (i in temperatures.indices.reversed()) {
            val cur = temperatures[i]
            while(decreasingTempIndicesStack.isNotEmpty() && temperatures[decreasingTempIndicesStack.last()] <= cur) {
                decreasingTempIndicesStack.removeLast()
            }
            decreasingTempIndicesStack.lastOrNull()?.let { lastIndex ->
                val lastTemp = temperatures[lastIndex]
                if (lastTemp > cur) {
                    result[i] = lastIndex - i
                }
            }
            decreasingTempIndicesStack.addLast(i)
        }
        return result
    }
}
