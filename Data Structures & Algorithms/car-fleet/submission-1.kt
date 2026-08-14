class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.zip(speed).sortedBy { it.first }
        val timeDecreasingStack = ArrayDeque<Float>()
        for (i in cars.indices) {
            val car = cars[i]
            val pos = car.first
            val speed = car.second
            val dist = target - pos
            val time = dist / speed.toFloat()
            while (timeDecreasingStack.isNotEmpty() && timeDecreasingStack.last() <= time) {
                timeDecreasingStack.removeLast()
            }
            timeDecreasingStack.addLast(time)
        }
        return timeDecreasingStack.size
    }
}
