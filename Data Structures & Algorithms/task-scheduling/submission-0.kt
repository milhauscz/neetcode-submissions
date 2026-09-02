class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frequencies = IntArray(26)
        val maxHeap = PriorityQueue<Char>() { charA, charB ->
            frequencies[charB - 'A'] - frequencies[charA - 'A']
        }
        for (task in tasks) {
            frequencies[task - 'A']++
        }
        for (i in 0..<26) {
            if (frequencies[i] > 0) {
                maxHeap.add('A' + i)
            }
        }
        val taskToCooldownCycles = mutableMapOf<Char,Int>()
        var cycles = 0
        while (maxHeap.isNotEmpty() || taskToCooldownCycles.isNotEmpty()) {
            val iterator = taskToCooldownCycles.iterator()
            while (iterator.hasNext()) {
                val (char, cooldown) = iterator.next()
                if (cooldown == 1) {
                    iterator.remove()
                    maxHeap.add(char)
                } else {
                    taskToCooldownCycles[char] = cooldown - 1
                }
            }

            if (maxHeap.isNotEmpty()) {
                val task = maxHeap.poll()
                val frequency = frequencies[task - 'A']--
                if (frequency > 1) {
                    if (n == 0) {
                        maxHeap.add(task)
                    } else {
                        taskToCooldownCycles[task] = n + 1
                    }
                }
            }
            cycles++
        }
        return cycles
    }
}