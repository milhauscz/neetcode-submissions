class MinStack() {
    private var stack = mutableListOf<Int>()
    private var minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        val min = minStack.lastOrNull()
        minStack.add(if (min == null) `val` else min(min, `val`))
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack[stack.size - 1]
    }

    fun getMin(): Int {
        return minStack[minStack.size - 1]
    }
}
